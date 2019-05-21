package base.consts;

import base.Instruction;
import thread.JVMThread;
import thread.Frame;

public class LConst_1 implements Instruction {
    private LConst_1(){    }

    private static LConst_1 instance = new LConst_1();

    public static LConst_1 getInstance(){
        return instance;
    }

    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.operandStack.pushD((long)1);
    }

}