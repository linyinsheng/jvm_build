package base.push;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class Bipush implements Instruction {

    private Bipush(){    }

    private static Bipush instance = new Bipush();

    public static Bipush getInstance(){
        return instance;
    }

    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
       frame.operandStack.pushT((int)codes[frame.pc++]);
    }
}
