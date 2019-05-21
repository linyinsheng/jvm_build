package base.push;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class Sipush implements Instruction {

    private Sipush(){    }

    private static Sipush instance = new Sipush();

    public static Sipush getInstance(){
        return instance;
    }

    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.operandStack.pushT((int)codes[frame.pc++]);
        System.out.println("未完");/**未玩成*/
    }
}
