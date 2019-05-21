package link.file.constantsPool;

public class InterfaceMethodrefInfo extends ConstantsInfo {
    short class_index;
    String class_name;
    short name_and_type_index;
    String name_and_type;

    public short getClass_index() {
        return class_index;
    }

    public void setClass_index(short class_index) {
        this.class_index = class_index;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public short getName_and_type_index() {
        return name_and_type_index;
    }

    public void setName_and_type_index(short name_and_type_index) {
        this.name_and_type_index = name_and_type_index;
    }

    public String getName_and_type() {
        return name_and_type;
    }

    public void setName_and_type(String name_and_type) {
        this.name_and_type = name_and_type;
    }
}
