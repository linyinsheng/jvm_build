package link;

import java.io.IOException;
import java.io.InputStream;

public class Read {
    /**
     * u2
     * @param in
     * @return
     * @throws IOException
     */
    public static short readU2(InputStream in) throws IOException {
        int temp = 0;
        for (int i = 0; i < 2; i++) {
            temp = temp<<8;
            temp = temp+in.read();
        }
        return (short) temp;
    }

    /**
     * u4
     * @param in
     * @return
     * @throws IOException
     */
    public static int readU4(InputStream in) throws IOException {
        int temp = 0;
        for (int i = 0; i < 4; i++) {
            temp = temp<<8;
            temp = temp+in.read();
        }
        return temp;
    }



}
