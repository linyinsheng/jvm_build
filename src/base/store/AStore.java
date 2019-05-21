package base.store;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class AStore implements Instruction {
    private static AStore instance = new AStore();
    private AStore(){}
    public static AStore getInstance(){
        return instance;
    }

    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.localVars.setD(codes[frame.pc++], frame.operandStack.popT());
    }
}
