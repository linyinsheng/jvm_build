package base.store;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class AStore_2 implements Instruction {
    private static AStore_2 instance = new AStore_2();
    private AStore_2(){}
    public static AStore_2 getInstance(){
        return instance;
    }

    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.localVars.setD(2, frame.operandStack.popT());
    }
}
