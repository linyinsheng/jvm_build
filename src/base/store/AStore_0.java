package base.store;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class AStore_0 implements Instruction {
    private static AStore_0 instance = new AStore_0();
    private AStore_0(){}
    public static AStore_0 getInstance(){
        return instance;
    }

    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.localVars.setD(0, frame.operandStack.popT());
    }
}
