package base.add;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class IAdd implements Instruction {
    private static IAdd instance = new IAdd();

    private IAdd(){}

    public static IAdd getInstance(){
        return instance;
    }

    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        int x = frame.operandStack.popT();
        int y = frame.operandStack.popT();
        int res = x+y;
        frame.operandStack.pushT(res);
    }
}
