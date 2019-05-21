package load;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipLoad implements Load {
    private static ZipLoad instance = new ZipLoad();
    private List<ZipFile> zipFiles = new ArrayList<>();
    private ZipLoad(){}

    public static ZipLoad getInstance(){
        return instance;
    }

    @Override
    public InputStream readClass(String className) throws IOException {
        ZipFile zipFile = null;
        for (int i = 0; i < zipFiles.size(); i++) {
            zipFile = zipFiles.get(i);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while (entries.hasMoreElements()){
                ZipEntry element = entries.nextElement();
                if (element.toString().equalsIgnoreCase(className)) {
                    return zipFile.getInputStream(element);
                }
            }
        }
        return null;
    }

    public List<ZipFile> getZipFiles() {
        return zipFiles;
    }

    public void setZipFiles(List<ZipFile> zipFiles) {
        this.zipFiles = zipFiles;
    }
}
