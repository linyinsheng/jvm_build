package link.file.attribute;

public class ExceptionsInfo extends AttributeInfo {
    short number_of_exceptions;
    short[] exception_index_table;

    public short getNumber_of_exceptions() {
        return number_of_exceptions;
    }

    public void setNumber_of_exceptions(short number_of_exceptions) {
        this.number_of_exceptions = number_of_exceptions;
    }

    public short[] getException_index_table() {
        return exception_index_table;
    }

    public void setException_index_table(short[] exception_index_table) {
        this.exception_index_table = exception_index_table;
    }
}
