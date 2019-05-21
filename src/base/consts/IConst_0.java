package base.consts;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class IConst_0 implements Instruction {
    private IConst_0(){    }

    private static IConst_0 instance = new IConst_0();

    public static IConst_0 getInstance(){
        return instance;
    }
    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.operandStack.pushT((int)0);
    }

}