package link.file.constantsPool;

public class IntegerInfo extends ConstantsInfo {
    int bytes;
    public IntegerInfo() {
        tag = Constants.CONSTANT_Integer;
    }

    public int getBytes() {
        return bytes;
    }

    public void setBytes(int bytes) {
        this.bytes = bytes;
    }
}
