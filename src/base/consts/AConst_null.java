package base.consts;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class AConst_null implements Instruction {
    private AConst_null(){    }

    private static AConst_null instance = new AConst_null();

    public static AConst_null getInstance(){
        return instance;
    }
    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.operandStack.pushD(null);
    }

}