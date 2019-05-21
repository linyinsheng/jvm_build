package memory;

import link.file.ClassFile;
import link.file.FieldInfo;
import link.file.MethodInfo;
import link.file.constantsPool.ConstantsInfo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Metaspace {
    /**
     * 类文件
     */
    Map<String, ClassFile> classFileMap = new HashMap<>();
    /**
     * 类对象判断
     */
    Set<String > classSet = new HashSet<>();
    /**
     * 方法表
     */
    Map<String, MethodInfo> methodInfoMap = new HashMap<>();
    /**
     * 字段表
     */
    Map<String, FieldInfo> fieldInfoMap = new HashMap<>();
    /**
     * 类变量表
     */
    Map<String, FieldInfo> classFieldInfoMap = new HashMap<>();
    /**
     * 常量池
     */
    Map<String, ConstantsInfo> constantsInfoMap = new HashMap<>();
    private static Metaspace instance = new Metaspace();

    private Metaspace(){}
    public static Metaspace getInstance(){
        return instance;
    }

    public Map<String, MethodInfo> getMethodInfoMap() {
        return methodInfoMap;
    }

    public void setMethodInfoMap(Map<String, MethodInfo> methodInfoMap) {
        this.methodInfoMap = methodInfoMap;
    }

    public Map<String, FieldInfo> getFieldInfoMap() {
        return fieldInfoMap;
    }

    public void setFieldInfoMap(Map<String, FieldInfo> fieldInfoMap) {
        this.fieldInfoMap = fieldInfoMap;
    }

    public Map<String, ConstantsInfo> getConstantsInfoMap() {
        return constantsInfoMap;
    }

    public void setConstantsInfoMap(Map<String, ConstantsInfo> constantsInfoMap) {
        this.constantsInfoMap = constantsInfoMap;
    }

    public Map<String, FieldInfo> getClassFieldInfoMap() {
        return classFieldInfoMap;
    }

    public void setClassFieldInfoMap(Map<String, FieldInfo> classFieldInfoMap) {
        this.classFieldInfoMap = classFieldInfoMap;
    }

    public Map<String, ClassFile> getClassFileMap() {
        return classFileMap;
    }

    public void setClassFileMap(Map<String, ClassFile> classFileMap) {
        this.classFileMap = classFileMap;
    }

    public Set<String> getClassSet() {
        return classSet;
    }

    public void setClassSet(Set<String> classSet) {
        this.classSet = classSet;
    }
}
