package base.consts;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class IConst_1 implements Instruction {
    private IConst_1(){    }

    private static IConst_1 instance = new IConst_1();

    public static IConst_1 getInstance(){
        return instance;
    }
    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.operandStack.pushT((int)1);
    }

}