package base.consts;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class IConst_m1 implements Instruction {
    private IConst_m1(){    }

    private static IConst_m1 instance = new IConst_m1();

    public static IConst_m1 getInstance(){
        return instance;
    }
    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.operandStack.pushT((int)-1);
    }

}