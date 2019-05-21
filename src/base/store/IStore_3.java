package base.store;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class IStore_3 implements Instruction {
    private static IStore_3 instance = new IStore_3();
    private IStore_3(){}
    public static IStore_3 getInstance(){
        return instance;
    }

    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        int data = (Integer) frame.operandStack.popT();
        frame.localVars.setD(3, data);
    }
}
