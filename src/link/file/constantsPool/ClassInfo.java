package link.file.constantsPool;

public class ClassInfo extends ConstantsInfo{
    short name_index;
    String class_name;
    public ClassInfo() {
        tag = Constants.CONSTANT_Class;
    }

    public short getName_index() {
        return name_index;
    }

    public void setName_index(short name_index) {
        this.name_index = name_index;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}
