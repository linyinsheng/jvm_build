package link.file;

import link.file.attribute.AttributeInfo;

public class FieldInfo {
    public final static int ACC_PUBLIC = 1;
    public final static int ACC_PRIVATE = 2;
    public final static int ACC_PROTECTED = 4;
    public final static int ACC_STATIC = 8;
    public final static int ACC_FINAL = 16;
    public final static int ACC_VOLATILE = 64;
    public final static int ACC_TRANSIENT = 128;
    public final static int ACC_SYNTHETIC = 4096;
    public final static int ACC_ENUM = 16384;
    short access_flags;
    short name_index;
    short descriptor_index;
    short attributes_count;

    String field_id;
    String descriptor;
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

    public String getField_id() {
        return field_id;
    }

    public void setField_id(String field_id) {
        this.field_id = field_id;
    }

    public String getDescriptor() {
        return descriptor;
    }

    public void setDescriptor(String descriptor) {
        this.descriptor = descriptor;
    }
}
