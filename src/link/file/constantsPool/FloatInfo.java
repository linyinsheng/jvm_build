package link.file.constantsPool;

public class FloatInfo extends ConstantsInfo{
    float bytes;
    public FloatInfo() {
        tag = Constants.CONSTANT_Float;
    }

    public float getBytes() {
        return bytes;
    }

    public void setBytes(float bytes) {
        this.bytes = bytes;
    }
}
