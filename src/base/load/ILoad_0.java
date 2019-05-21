package base.load;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class ILoad_0 implements Instruction {
    private static ILoad_0 instance = new ILoad_0();

    private ILoad_0(){}

    public static ILoad_0 getInstance(){
        return instance;
    }

    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.operandStack.pushT(frame.localVars.getT(0));
    }
}
