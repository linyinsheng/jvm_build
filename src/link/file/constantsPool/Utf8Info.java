package link.file.constantsPool;

public class Utf8Info extends ConstantsInfo {
    short length;
    byte[] bytes;
    String name;
    public Utf8Info() {
        tag = Constants.CONSTANT_Utf8;
    }

    public short getLength() {
        return length;
    }

    public void setLength(short length) {
        this.length = length;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
