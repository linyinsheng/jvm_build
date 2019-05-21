package link.file;

import link.file.attribute.AttributeInfo;

public class MethodInfo {
    public final static int ACC_PUBLIC = 1;
    public final static int ACC_PRIVATE = 2;
    public final static int ACC_PROTECTED = 4;
    public final static int ACC_STATIC = 8;
    public final static int ACC_FINAL = 16;
    public final static int ACC_SYNCHRONIZED = 32;
    public final static int ACC_BRIDGE = 64;
    public final static int ACC_VARARGS = 128;
    public final static int ACC_NATIVE = 256;
    public final static int ACC_ABSTRACT = 1024;
    public final static int ACC_STRICT = 2048;
    public final static int ACC_SYNTHETIC = 4096;
    /**
     * 访问标志
     */
    short access_flags;
    /**
     * 名称索引
     */
    short name_index;
    /**
     * 描述符索引
     */
    short descriptor_index;
    /**
     * 方法名称+描述符
     */
    String method_id;
    /**
     * 属性计数器
     */
    short attributes_count;
    /**
     * 属性表
     */
    AttributeInfo[] attributes;

    public short getAccess_flags() {
        return access_flags;
    }

    public void setAccess_flags(short access_flags) {
        this.access_flags = access_flags;
    }

    public short getName_index() {
        return name_index;
    }

    public void setName_index(short name_index) {
        this.name_index = name_index;
    }

    public short getDescriptor_index() {
        return descriptor_index;
    }

    public void setDescriptor_index(short descriptor_index) {
        this.descriptor_index = descriptor_index;
    }

    public short getAttributes_count() {
        return attributes_count;
    }

    public void setAttributes_count(short attributes_count) {
        this.attributes_count = attributes_count;
    }

    public AttributeInfo[] getAttributes() {
        return attributes;
    }

    public void setAttributes(AttributeInfo[] attributes) {
        this.attributes = attributes;
    }

    public String getMethod_id() {
        return method_id;
    }

    public void setMethod_id(String method_id) {
        this.method_id = method_id;
    }
}
