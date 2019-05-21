package base.consts;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class FConst_1 implements Instruction {
    private FConst_1(){    }

    private static FConst_1 instance = new FConst_1();

    public static FConst_1 getInstance(){
        return instance;
    }
    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.operandStack.pushT((float)1);
    }

}