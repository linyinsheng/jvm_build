package link.file.attribute;

public abstract class AttributeInfo {
    /**
     * 属性名称索引
     */
    short attribute_name_index;
    /**
     * 属性表长度
     */
    int attribute_length;

    public short getAttribute_name_index() {
        return attribute_name_index;
    }

    public void setAttribute_name_index(short attribute_name_index) {
        this.attribute_name_index = attribute_name_index;
    }

    public int getAttribute_length() {
        return attribute_length;
    }

    public void setAttribute_length(int attribute_length) {
        this.attribute_length = attribute_length;
    }
}
