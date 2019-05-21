package base.store;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class IStore_0 implements Instruction {
    private static IStore_0 instance = new IStore_0();
    private IStore_0(){}
    public static IStore_0 getInstance(){
        return instance;
    }

    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        int data = (Integer) frame.operandStack.popT();
        frame.localVars.setD(0, data);
    }
}
