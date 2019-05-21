package base;

import thread.Frame;
import thread.JVMThread;

public interface Instruction {

//    public void fetchOperands();

    public void execute(Frame frame, JVMThread JVMThread, byte[] codes);

}
