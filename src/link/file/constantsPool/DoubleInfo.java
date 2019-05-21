package link.file.constantsPool;

public class DoubleInfo extends ConstantsInfo{
    int high_bytes;
    int low_bytes;
    public DoubleInfo() {
        tag = Constants.CONSTANT_Double;
    }

    public int getHigh_bytes() {
        return high_bytes;
    }

    public void setHigh_bytes(int high_bytes) {
        this.high_bytes = high_bytes;
    }

    public int getLow_bytes() {
        return low_bytes;
    }

    public void setLow_bytes(int low_bytes) {
        this.low_bytes = low_bytes;
    }
}
