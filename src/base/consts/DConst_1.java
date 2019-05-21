package base.consts;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class DConst_1 implements Instruction {
    private DConst_1(){    }

    private static DConst_1 instance = new DConst_1();

    public static DConst_1 getInstance(){
        return instance;
    }
    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.operandStack.pushD((double)1);
    }

}