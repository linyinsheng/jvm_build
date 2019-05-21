package base.consts;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class FConst_2 implements Instruction {
    private FConst_2(){    }

    private static FConst_2 instance = new FConst_2();

    public static FConst_2 getInstance(){
        return instance;
    }
    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.operandStack.pushT((float)2);
    }

}