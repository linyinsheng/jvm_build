package base.load;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class ILoad_3 implements Instruction {
    private static ILoad_3 instance = new ILoad_3();

    private ILoad_3(){}

    public static ILoad_3 getInstance(){
        return instance;
    }

    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        frame.operandStack.pushT(frame.localVars.getT(3));
    }
}
