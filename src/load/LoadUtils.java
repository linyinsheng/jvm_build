package load;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipFile;

public class LoadUtils {
    private LoadUtils(){    }

    static {
        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 目前只查启动类路径（zip）、扩展类路径（zip）和用户类路径（dir）
     * @param className
     * @return
     * @throws IOException
     */
    public static InputStream readClass(String className) throws IOException {
        className = className+".class";
        InputStream inputStream = ZipLoad.getInstance().readClass(className);
        if (inputStream != null){
            return inputStream;
        }
        className = "/"+className;
        inputStream = DirLoad.getInstance().readClass(className);
        return inputStream;
    }

    /**
     * 初始化
     * @throws IOException
     */
    private static void init() throws IOException {
        Properties properties = System.getProperties();
        String classPath = (String) properties.get("java.class.path");
        String[] paths = new String[0];
        String os = properties.get("os.name").toString();
        List<ZipFile> zipList = ZipLoad.getInstance().getZipFiles();
        List<File> dirList = DirLoad.getInstance().getDirFiles();
        if (os.indexOf("Linux") != -1){
            paths = classPath.split(":");
        }else if(os.indexOf("Windows") != -1){
            paths = classPath.split(";");
        }else {
            throw new IOException("当前为未知系统");
        }

        for (int i = 0; i < paths.length; i++) {
            if (paths[i].lastIndexOf("jar") != -1 || paths[i].lastIndexOf("zip") != -1){
                zipList.add(new ZipFile(paths[i]));
            }else {
                dirList.add(new File(paths[i]));
            }
        }
    }

}
