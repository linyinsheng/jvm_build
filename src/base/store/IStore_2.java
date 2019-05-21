package base.store;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class IStore_2 implements Instruction {
    private static IStore_2 instance = new IStore_2();
    private IStore_2(){}
    public static IStore_2 getInstance(){
        return instance;
    }

    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        int data = (Integer) frame.operandStack.popT();
        frame.localVars.setD(2, data);
    }
}
