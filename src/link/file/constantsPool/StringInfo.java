package link.file.constantsPool;

public class StringInfo extends ConstantsInfo{
    short string_index;
    String string;
    public StringInfo() {
        tag = Constants.CONSTANT_Class;
    }

    public short getString_index() {
        return string_index;
    }

    public void setString_index(short string_index) {
        this.string_index = string_index;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
