package base.consts;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class DConst_0 implements Instruction {
    private DConst_0(){    }

    private static DConst_0 instance = new DConst_0();

    public static DConst_0 getInstance(){
        return instance;
    }
    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.operandStack.pushD((double)0);
    }

}