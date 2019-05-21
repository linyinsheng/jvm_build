package base.store;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class AStore_1 implements Instruction {
    private static AStore_1 instance = new AStore_1();
    private AStore_1(){}
    public static AStore_1 getInstance(){
        return instance;
    }

    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.localVars.setD(1, frame.operandStack.popT());
    }
}
