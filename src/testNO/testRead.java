package testNO;

import link.ParseUtils;
import link.file.ClassFile;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class testRead {
    public static void main(String[] args) throws IOException {
        Map<String, String> getenv = System.getenv();
        String path = "";
        String PATH = getenv.get("PATH");
        String[] split = PATH.split(":");
        for (String  str: split) {
            if (str.indexOf("jvm") != -1){
                path = str;
                break;
            }
        }
        path = path.substring(0, path.lastIndexOf("/"))+"/jre/lib";
        System.out.println(path);
        System.out.println("------------------------");
        File file = new File(path);
        File[] files = file.listFiles();
        int count = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().lastIndexOf("jar") != -1){
//                System.out.println(files[i].getName());
                count++;
            }
        }
        file = new File(path+"/ext");
        files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().lastIndexOf("jar") != -1) {
//                System.out.println(files[i].getName());
                count++;
            }
        }
        System.out.println(count);


//        System.out.println(System.getProperty("os.name"));
        Properties properties = System.getProperties();
//        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
//        for (Map.Entry entry:entries){
//            System.out.println(entry.getKey()+" : "+entry.getValue());
//        }








        String string = (String) properties.get("java.class.path");
//        System.out.println(string);
        if (properties.get("os.name").toString().indexOf("Linux") != -1){
            split = string.split(":");
        }
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }
        System.out.println(split.length);
        System.out.println(split[20]);
        File zipFile = new File(split[20]);
        String[] list = file.list();
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]+"  I"+i);
        }

        ZipFile zip = new ZipFile(split[20]);
        Enumeration<? extends ZipEntry> entries = zip.entries();
        while (entries.hasMoreElements()){
            ZipEntry element = entries.nextElement();
            String str = element.toString();
            if (str.equalsIgnoreCase("java/lang/Object.class")){
                File cl = new File(split[20]+"/java/lang/Object.class");
                ClassFile classFile = new ClassFile();
                //InputStream in = new FileInputStream(cl);
                ParseUtils.parse(zip.getInputStream(element));
//                System.out.println(zip.getInputStream(element));
                System.out.println("解析完成");
            }

        }


    }
}
