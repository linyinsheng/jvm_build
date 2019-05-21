package base.consts;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class LConst_0 implements Instruction {
    private LConst_0(){    }

    private static LConst_0 instance = new LConst_0();

    public static LConst_0 getInstance(){
        return instance;
    }
    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.operandStack.pushD((long)0);
    }

}