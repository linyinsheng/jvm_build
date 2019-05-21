package base;

import thread.Frame;
import thread.JVMThread;

public class Nop implements Instruction {
    private Nop(){    }

    private static Nop instance = new Nop();

    public static Nop getInstance(){
        return instance;
    }

    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {

    }
}