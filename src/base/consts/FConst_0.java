package base.consts;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class FConst_0 implements Instruction {
    private FConst_0(){    }

    private static FConst_0 instance = new FConst_0();

    public static FConst_0 getInstance(){
        return instance;
    }
    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.operandStack.pushT((float)0);
    }

}