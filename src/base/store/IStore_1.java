package base.store;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class IStore_1 implements Instruction {
    private static IStore_1 instance = new IStore_1();
    private IStore_1(){}
    public static IStore_1 getInstance(){
        return instance;
    }

    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        int data = (Integer) frame.operandStack.popT();
        frame.localVars.setD(1, data);
    }
}
