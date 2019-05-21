package base.consts;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class IConst_5 implements Instruction {
    private IConst_5(){    }

    private static IConst_5 instance = new IConst_5();

    public static IConst_5 getInstance(){
        return instance;
    }
    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.operandStack.pushT((int)5);
    }

}