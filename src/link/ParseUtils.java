package link;

import link.file.ClassFile;
import link.file.FieldInfo;
import link.file.MethodInfo;
import link.file.attribute.AttributeInfo;
import link.file.attribute.AttributeUtils;
import link.file.constantsPool.ClassInfo;
import link.file.constantsPool.ConstantsUtils;
import link.file.constantsPool.Utf8Info;
import memory.Metaspace;

import java.io.IOException;
import java.io.InputStream;

public class ParseUtils {

    /**
     * 解析class文件
     * @param in
     * @return
     * @throws IOException
     */
    public static ClassFile parse(InputStream in) throws IOException {
        ClassFile classFile = new ClassFile();
        parseMagic(in, classFile);  //魔数
        classFile.setMinor_version(Read.readU2(in)); //次版本号
        classFile.setMajor_version(Read.readU2(in));    //主版本号
        ConstantsUtils.parseConstantPool(in, classFile);    //常量池
        ResolutionUtils.constantPool(classFile); //常量池索引解析为符号
        classFile.setAccess_flags(Read.readU2(in)); //访问标志
        parseThisClass(in, classFile);      //类索引
        parseSuperClass(in, classFile);     //父类索引
        parseInteface(in, classFile);   //接口表
        parseFields(in, classFile);      //字段表
        parseMethods(in, classFile);    //方法表
        parseAttribute(in, classFile);  //属性表
        in.close();
        Metaspace.getInstance().getClassFileMap().put(classFile.getClass_name(), classFile);
        return classFile;
    }

    /**
     * 解析父类索引
     * @param in
     * @param classFile
     * @throws IOException
     */
    private static void parseSuperClass(InputStream in, ClassFile classFile) throws IOException {
        short index = Read.readU2(in);
        classFile.setSuper_class(index);
        if (index != 0){
            classFile.setSuper_class_name(((ClassInfo)classFile.getConstantsInfos()[index]).getClass_name());
        }
    }

    /**
     * 解析类索引
     * @param in
     * @param classFile
     * @throws IOException
     */
    private static void parseThisClass(InputStream in, ClassFile classFile) throws IOException {
        short index = Read.readU2(in);
        classFile.setThis_class(index);
        classFile.setClass_name(((ClassInfo)classFile.getConstantsInfos()[index]).getClass_name());
    }

    /**
     * 解析魔数
     * @param in
     * @param classFile
     * @throws IOException
     */
    private static void parseMagic(InputStream in, ClassFile classFile) throws IOException {
        int magic = Read.readU4(in);
        if (-889275714 != magic){
            throw new IOException("魔数错误");
        }
        classFile.setMagic(magic);
    }

    /**
     * 解析属性表
     * @param in
     * @param classFile
     * @throws IOException
     */
    private static void parseAttribute(InputStream in, ClassFile classFile) throws IOException {
        short count = Read.readU2(in);
        classFile.setAttributes_count(count);
        classFile.setAttribute(new AttributeInfo[count]);
        for (int i = 0; i < count; i++) {
            classFile.getAttribute()[i] = AttributeUtils.parseAttribute(in, classFile);
        }
    }

    /**
     * 解析方法表
     * @param in
     * @param classFile
     * @throws IOException
     */
    private static void parseMethods(InputStream in, ClassFile classFile) throws IOException {
        short count = Read.readU2(in);
        classFile.setMethods_count(count);
        classFile.setMethods(new MethodInfo[count]);
        for (int i = 0; i < count; i++) {
            MethodInfo methodrefInfo = parseMethod(in, classFile);
            classFile.getMethods()[i] = methodrefInfo;
        }
    }

    /**
     * 解析方法
     * @param in
     * @param classFile
     * @return
     * @throws IOException
     */
    private static MethodInfo parseMethod(InputStream in, ClassFile classFile) throws IOException {
        MethodInfo methodInfo = new MethodInfo();
        methodInfo.setAccess_flags(Read.readU2(in));
        methodInfo.setName_index(Read.readU2(in));
        methodInfo.setDescriptor_index(Read.readU2(in));
        Utf8Info name = (Utf8Info)classFile.getConstantsInfos()[methodInfo.getName_index()];
        Utf8Info descriptor = (Utf8Info)classFile.getConstantsInfos()[methodInfo.getDescriptor_index()];
        String id = classFile.getClass_name()+"."+name.getName()+":"+descriptor.getName();
        methodInfo.setMethod_id(id);
        AttributeUtils.parseAttributes(in, methodInfo, classFile);
        return methodInfo;
    }


    /**
     * 解析字段表
     * @param in
     * @param classFile
     * @throws IOException
     */
    private static void parseFields(InputStream in, ClassFile classFile) throws IOException {
        short count = Read.readU2(in);
        classFile.setFields_count(count);
        classFile.setFields(new FieldInfo[count]);
        for (int i = 0; i < count; i++) {
            FieldInfo fieldInfo = parseField(in, classFile);
            classFile.getFields()[i] = fieldInfo;
        }
    }

    /**
     * 解析字段
     * @param in
     * @param classFile
     * @return
     * @throws IOException
     */
    private static FieldInfo parseField(InputStream in, ClassFile classFile) throws IOException {
        FieldInfo fieldInfo = new FieldInfo();
        fieldInfo.setAccess_flags(Read.readU2(in));
        fieldInfo.setName_index(Read.readU2(in));
        Utf8Info utf8Info = (Utf8Info) classFile.getConstantsInfos()[fieldInfo.getName_index()];
        fieldInfo.setField_id(classFile.getClass_name()+"."+utf8Info.getName());
        fieldInfo.setDescriptor_index(Read.readU2(in));
        utf8Info = (Utf8Info) classFile.getConstantsInfos()[fieldInfo.getDescriptor_index()];
        fieldInfo.setDescriptor(utf8Info.getName());
        AttributeUtils.parseAttributes(in, fieldInfo, classFile);
        return fieldInfo;
    }


    /**
     * 解析接口表
     * @param in
     * @param classFile
     * @throws IOException
     */
    private static void parseInteface(InputStream in, ClassFile classFile) throws IOException {
        short count = Read.readU2(in);
        classFile.setInterfaces_count(count);
        classFile.setInterfaces(new short[count]);
        for (int i = 0; i < count; i++) {
            classFile.getInterfaces()[i] = Read.readU2(in);
        }
    }



}
