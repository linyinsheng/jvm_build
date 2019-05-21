package base.consts;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class IConst_3 implements Instruction {
    private IConst_3(){    }

    private static IConst_3 instance = new IConst_3();

    public static IConst_3 getInstance(){
        return instance;
    }
    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.operandStack.pushT((int)3);
    }

}