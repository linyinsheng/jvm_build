package link.file.attribute;

public class LineNumberTableInfo extends AttributeInfo {
    short line_number_table_length;
    short[][] line_number_table;

    public short getLine_number_table_length() {
        return line_number_table_length;
    }

    public void setLine_number_table_length(short line_number_table_length) {
        this.line_number_table_length = line_number_table_length;
    }

    public short[][] getLine_number_table() {
        return line_number_table;
    }

    public void setLine_number_table(short[][] line_number_table) {
        this.line_number_table = line_number_table;
    }
}
