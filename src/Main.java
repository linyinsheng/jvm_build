import memory.Metaspace;
import thread.JVMThread;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JVMThread jvmThread = new JVMThread();
        String main = "testNO/testClass.main:([Ljava/lang/String;)V";
        jvmThread.execute(main);

        Metaspace instance = Metaspace.getInstance();
        instance.hashCode();
    }

}
