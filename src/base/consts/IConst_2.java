package base.consts;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class IConst_2 implements Instruction {
    private IConst_2(){    }

    private static IConst_2 instance = new IConst_2();

    public static IConst_2 getInstance(){
        return instance;
    }
    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.operandStack.pushT((int)2);
    }

}