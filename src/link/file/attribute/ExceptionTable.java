package link.file.attribute;

public class ExceptionTable {
    short start_pc;
    short end_pc;
    short handle_pc;
    short catch_type;

    public short getStart_pc() {
        return start_pc;
    }

    public void setStart_pc(short start_pc) {
        this.start_pc = start_pc;
    }

    public short getEnd_pc() {
        return end_pc;
    }

    public void setEnd_pc(short end_pc) {
        this.end_pc = end_pc;
    }

    public short getHandle_pc() {
        return handle_pc;
    }

    public void setHandle_pc(short handle_pc) {
        this.handle_pc = handle_pc;
    }

    public short getCatch_type() {
        return catch_type;
    }

    public void setCatch_type(short catch_type) {
        this.catch_type = catch_type;
    }
}
