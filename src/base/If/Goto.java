package base.If;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class Goto implements Instruction {
    private static Goto instance = new Goto();

    private Goto(){}

    public static Goto getInstance(){
        return instance;
    }

    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        int size = codes[frame.pc]-1;
        size += codes[frame.pc+1];
        frame.pc += size;
    }
}
