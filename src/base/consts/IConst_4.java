package base.consts;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class IConst_4 implements Instruction {
    private IConst_4(){    }

    private static IConst_4 instance = new IConst_4();

    public static IConst_4 getInstance(){
        return instance;
    }
    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.operandStack.pushT((int)4);
    }

}