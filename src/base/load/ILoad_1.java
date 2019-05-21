package base.load;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class ILoad_1 implements Instruction {
    private static ILoad_1 instance = new ILoad_1();

    private ILoad_1(){}

    public static ILoad_1 getInstance(){
        return instance;
    }

    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.operandStack.pushT(frame.localVars.getT(1));
    }
}
