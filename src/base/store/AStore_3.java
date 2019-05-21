package base.store;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class AStore_3 implements Instruction {
    private static AStore_3 instance = new AStore_3();
    private AStore_3(){}
    public static AStore_3 getInstance(){
        return instance;
    }

    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.localVars.setD(3, frame.operandStack.popT());
    }
}
