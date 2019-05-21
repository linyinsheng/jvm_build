package link.file;

import link.file.attribute.AttributeInfo;
import link.file.constantsPool.ConstantsInfo;

public class ClassFile {
    public final static int ACC_PUBLIC = 1;
    public final static int ACC_FINAL = 16;
    public final static int ACC_SUPER = 32;
    public final static int ACC_INTERFACE = 512;
    public final static int ACC_ABSTRACT = 1024;
    public final static int ACC_SYNTHETIC = 4096;
    public final static int ACC_ANNOTATION = 8192;
    public final static int ACC_ENUM = 16384;
    /**
     * 魔数
     */
    int magic;
    /**
     * 副版本号
     */
    short minor_version;
    /**
     * 主版本号
     */
    short major_version;
    /**
     * 常量池计数器
     */
    short constant_pool_count;
    /**
     * 常量池
     */
    ConstantsInfo[] constantsInfos;
    /**
     * 访问标志
     */
    short access_flags;
    /**
     * 类索引
     */
    short this_class;
    /**
     * 类全全称
     */
    String class_name;
    /**
     * 父类索引
     */
    short super_class;
    /**
     * 父类全称
     */
    String super_class_name;
    /**
     * 接口计数器
     */
    short interfaces_count;
    /**
     * 接口表
     */
    short[] interfaces;
    /**
     * 字段计数器
     */
    short fields_count;
    /**
     * 字段表
     */
    FieldInfo[] fields;
    /**
     * 方法计数器
     */
    short methods_count;
    /**
     * 方法表
     */
    MethodInfo[] methods;
    /**
     * 属性计数器
     */
    short attributes_count;
    /**
     * 属性表
     */
    AttributeInfo[] attribute;

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public short getMinor_version() {
        return minor_version;
    }

    public void setMinor_version(short minor_version) {
        this.minor_version = minor_version;
    }

    public short getMajor_version() {
        return major_version;
    }

    public void setMajor_version(short major_version) {
        this.major_version = major_version;
    }

    public short getConstant_pool_count() {
        return constant_pool_count;
    }

    public void setConstant_pool_count(short constant_pool_count) {
        this.constant_pool_count = constant_pool_count;
    }

    public ConstantsInfo[] getConstantsInfos() {
        return constantsInfos;
    }

    public void setConstantsInfos(ConstantsInfo[] constantsInfos) {
        this.constantsInfos = constantsInfos;
    }

    public short getAccess_flags() {
        return access_flags;
    }

    public void setAccess_flags(short access_flags) {
        this.access_flags = access_flags;
    }

    public short getThis_class() {
        return this_class;
    }

    public void setThis_class(short this_class) {
        this.this_class = this_class;
    }

    public short getSuper_class() {
        return super_class;
    }

    public void setSuper_class(short super_class) {
        this.super_class = super_class;
    }

    public short getInterfaces_count() {
        return interfaces_count;
    }

    public void setInterfaces_count(short interfaces_count) {
        this.interfaces_count = interfaces_count;
    }

    public short[] getInterfaces() {
        return interfaces;
    }

    public void setInterfaces(short[] interfaces) {
        this.interfaces = interfaces;
    }

    public short getFields_count() {
        return fields_count;
    }

    public void setFields_count(short fields_count) {
        this.fields_count = fields_count;
    }

    public FieldInfo[] getFields() {
        return fields;
    }

    public void setFields(FieldInfo[] fields) {
        this.fields = fields;
    }

    public short getMethods_count() {
        return methods_count;
    }

    public void setMethods_count(short methods_count) {
        this.methods_count = methods_count;
    }

    public MethodInfo[] getMethods() {
        return methods;
    }

    public void setMethods(MethodInfo[] methods) {
        this.methods = methods;
    }

    public short getAttributes_count() {
        return attributes_count;
    }

    public void setAttributes_count(short attributes_count) {
        this.attributes_count = attributes_count;
    }

    public AttributeInfo[] getAttribute() {
        return attribute;
    }

    public void setAttribute(AttributeInfo[] attribute) {
        this.attribute = attribute;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getSuper_class_name() {
        return super_class_name;
    }

    public void setSuper_class_name(String super_class_name) {
        this.super_class_name = super_class_name;
    }
}
