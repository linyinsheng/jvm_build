package base.If;

import base.Instruction;
import thread.Frame;
import thread.JVMThread;

public class If_Icmple implements Instruction {
    private static If_Icmple instance = new If_Icmple();

    private If_Icmple(){}

    public static If_Icmple getInstance(){
        return instance;
    }

    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        int x = frame.operandStack.popT();
        int y = frame.operandStack.popT();
        if (x-y >= 0){
            frame.pc = codes[++frame.pc];
        }else {
            frame.pc+=2;
        }
    }
}
