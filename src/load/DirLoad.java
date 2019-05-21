package load;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DirLoad implements Load{
    private List<File> dirFiles = new ArrayList<>();
    private static DirLoad instance = new DirLoad();
    private DirLoad(){  }

    public static DirLoad getInstance(){
        return instance;
    }

    @Override
    public InputStream readClass(String className) throws IOException {
        for (int i = 0; i < dirFiles.size(); i++) {
            String path = dirFiles.get(i).getPath()+className;
            File file = new File(path);
            if (file.exists()){
                return new FileInputStream(file);
            }
        }
        return null;
    }

    public List<File> getDirFiles() {
        return dirFiles;
    }

    public void setDirFiles(List<File> dirFiles) {
        this.dirFiles = dirFiles;
    }
}
