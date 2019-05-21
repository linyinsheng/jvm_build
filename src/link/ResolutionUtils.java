package link;

import link.file.ClassFile;
import link.file.FieldInfo;
import link.file.MethodInfo;
import link.file.constantsPool.*;
import load.LoadUtils;
import memory.Metaspace;

import java.io.IOException;
import java.util.Map;

public class ResolutionUtils {

    public static void resolution(String className) throws IOException {
        Metaspace metaspace = Metaspace.getInstance();
        if (!metaspace.getClassFileMap().containsKey(className)){
            metaspace.getClassFileMap().put(className, ParseUtils.parse(LoadUtils.readClass(className)));
        }
        ClassFile classFile = metaspace.getClassFileMap().get(className);
        resolution(classFile);
    }

    public static void resolution(ClassFile classFile) throws IOException {
        Metaspace metaspace = Metaspace.getInstance();
        String super_class_name = classFile.getSuper_class_name();
        if (!metaspace.getClassSet().contains(super_class_name) && super_class_name != null){
            if (metaspace.getClassFileMap().containsKey(super_class_name)){
                resolution(metaspace.getClassFileMap().get(super_class_name));
            }else {
                resolution(ParseUtils.parse(LoadUtils.readClass(super_class_name)));
            }
        }
        resolutionObject(metaspace, classFile);
        resolutionField(metaspace, classFile);
        resolutionMethods(metaspace, classFile);
        metaspace.getClassSet().add(classFile.getClass_name());
    }

    private static void resolutionObject(Metaspace metaspace, ClassFile classFile) {
        Map<String, ConstantsInfo> constantsInfoMap = metaspace.getConstantsInfoMap();
        ConstantsInfo[] constantsInfos = classFile.getConstantsInfos();
        for (int i = 0; i < constantsInfos.length; i++) {
            if (constantsInfos[i] instanceof StringInfo
                    || constantsInfos[i] instanceof IntegerInfo
                    || constantsInfos[i] instanceof FloatInfo
                    || constantsInfos[i] instanceof LongInfo
                    || constantsInfos[i] instanceof DoubleInfo){
                constantsInfoMap.put(classFile.getClass_name()+"."+i, constantsInfos[i]);
            }
        }
    }

    private static void resolutionField(Metaspace metaspace, ClassFile classFile) {
        Map<String, FieldInfo> fieldInfoMap = metaspace.getFieldInfoMap();
        Map<String, FieldInfo> classFieldInfoMap = metaspace.getClassFieldInfoMap();
        FieldInfo[] fields = classFile.getFields();
        for (int i = 0; i < fields.length; i++) {
            int access_flags = fields[i].getAccess_flags();
            if ((access_flags & FieldInfo.ACC_STATIC) == FieldInfo.ACC_STATIC){
                classFieldInfoMap.put(fields[i].getField_id(), fields[i]);
            }else {
                fieldInfoMap.put(fields[i].getField_id(), fields[i]);
            }
        }
    }

    private static void resolutionMethods(Metaspace metaspace, ClassFile classFile) {
        Map<String, MethodInfo> methodInfoMap = metaspace.getMethodInfoMap();
        MethodInfo[] methods = classFile.getMethods();
        for (int i = 0; i < methods.length; i++) {
            methodInfoMap.put(methods[i].getMethod_id(), methods[i]);
        }
    }


    public static void constantPool(ClassFile classFile) {
        ConstantsInfo[] constantsInfos = classFile.getConstantsInfos();
        for (int i = 0; i < constantsInfos.length; i++) {
            if (constantsInfos[i] instanceof ClassInfo){
                ClassInfo classInfo = (ClassInfo)constantsInfos[i];
                Utf8Info utf8Info = (Utf8Info)constantsInfos[classInfo.getName_index()];
                classInfo.setClass_name(utf8Info.getName());
            }else if(constantsInfos[i] instanceof StringInfo){
                StringInfo stringInfo = (StringInfo)constantsInfos[i];
                Utf8Info utf8Info = (Utf8Info)constantsInfos[stringInfo.getString_index()];
                stringInfo.setString(utf8Info.getName());
            }else if(constantsInfos[i] instanceof NameAndTypeInfo){
                NameAndTypeInfo nameAndTypeInfo = (NameAndTypeInfo) constantsInfos[i];
                Utf8Info utf8Info = (Utf8Info) constantsInfos[nameAndTypeInfo.getName_index()];
                nameAndTypeInfo.setName(utf8Info.getName());
                utf8Info = (Utf8Info)constantsInfos[nameAndTypeInfo.getDescriptor_index()];
                nameAndTypeInfo.setDescriptor(utf8Info.getName());
            }
        }

        for (int i = 0; i < constantsInfos.length; i++) {
            if (constantsInfos[i] instanceof FieldrefInfo){
                FieldrefInfo fieldrefInfo = (FieldrefInfo)constantsInfos[i];
                ClassInfo classInfo = (ClassInfo) constantsInfos[fieldrefInfo.getClass_index()];
                fieldrefInfo.setClass_name(classInfo.getClass_name());
                NameAndTypeInfo nameAndTypeInfo = (NameAndTypeInfo)constantsInfos[fieldrefInfo.getName_and_type_index()];
                fieldrefInfo.setName_and_type(nameAndTypeInfo.getName()+":"+nameAndTypeInfo.getDescriptor());
            }else if (constantsInfos[i] instanceof MethodrefInfo){
                MethodrefInfo methodrefInfo = (MethodrefInfo)constantsInfos[i];
                ClassInfo classInfo = (ClassInfo) constantsInfos[methodrefInfo.getClass_index()];
                methodrefInfo.setClass_name(classInfo.getClass_name());
                NameAndTypeInfo nameAndTypeInfo = (NameAndTypeInfo)constantsInfos[methodrefInfo.getName_and_type_index()];
                methodrefInfo.setName_and_type(nameAndTypeInfo.getName()+":"+nameAndTypeInfo.getDescriptor());
            }else if(constantsInfos[i] instanceof InterfaceMethodrefInfo){
                InterfaceMethodrefInfo interfaceMethodrefInfo = (InterfaceMethodrefInfo)constantsInfos[i];
                ClassInfo classInfo = (ClassInfo) constantsInfos[interfaceMethodrefInfo.getClass_index()];
                interfaceMethodrefInfo.setClass_name(classInfo.getClass_name());
                NameAndTypeInfo nameAndTypeInfo = (NameAndTypeInfo)constantsInfos[interfaceMethodrefInfo.getName_and_type_index()];
                interfaceMethodrefInfo.setName_and_type(nameAndTypeInfo.getName()+":"+nameAndTypeInfo.getDescriptor());
            }
        }
    }
}
