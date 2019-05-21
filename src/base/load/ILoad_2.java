package base.load;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class ILoad_2 implements Instruction {
    private static ILoad_2 instance = new ILoad_2();

    private ILoad_2(){}

    public static ILoad_2 getInstance(){
        return instance;
    }

    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.operandStack.pushT(frame.localVars.getT(2));
    }
}
