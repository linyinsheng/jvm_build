package link.file.attribute;

/**
 * Code属性
 * 代码存在位置
 */
public class CodeInfo extends AttributeInfo{
    short max_stack;
    short max_locals;
    int code_length;
    byte[] code;
    short exception_table_length;
    ExceptionTable[] exceptionTables;
    short attributes_count;
    AttributeInfo[] attributes;

    public short getMax_stack() {
        return max_stack;
    }

    public void setMax_stack(short max_stack) {
        this.max_stack = max_stack;
    }

    public short getMax_locals() {
        return max_locals;
    }

    public void setMax_locals(short max_locals) {
        this.max_locals = max_locals;
    }

    public int getCode_length() {
        return code_length;
    }

    public void setCode_length(int code_length) {
        this.code_length = code_length;
    }

    public byte[] getCode() {
        return code;
    }

    public void setCode(byte[] code) {
        this.code = code;
    }

    public short getException_table_length() {
        return exception_table_length;
    }

    public void setException_table_length(short exception_table_length) {
        this.exception_table_length = exception_table_length;
    }

    public ExceptionTable[] getExceptionTables() {
        return exceptionTables;
    }

    public void setExceptionTables(ExceptionTable[] exceptionTables) {
        this.exceptionTables = exceptionTables;
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
}
