package link.file.attribute;

public class LocalVariableTableInfo extends AttributeInfo {
    short local_variable_table_length;
    short[][] local_variable_table;

    public short getLocal_variable_table_length() {
        return local_variable_table_length;
    }

    public void setLocal_variable_table_length(short local_variable_table_length) {
        this.local_variable_table_length = local_variable_table_length;
    }

    public short[][] getLocal_variable_table() {
        return local_variable_table;
    }

    public void setLocal_variable_table(short[][] local_variable_table) {
        this.local_variable_table = local_variable_table;
    }
}
