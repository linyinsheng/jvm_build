package thread;

import base.InstructionFactory;

public class Frame {
    public OperandStack operandStack;
    public LocalVars localVars;
    public Frame lower;
    public int pc;
    public String className;

    public Frame(int stack, int locals, Frame top, String className) {
        operandStack = new OperandStack(stack);
        localVars = new LocalVars(locals);
        lower = top;
        pc = 0;
        this.className = className;
    }

    public void execute(byte[] codes, JVMThread jvmThread) {
        while(pc < codes.length){
            InstructionFactory.instruction(codes[pc++]).execute(this, jvmThread, codes);
        }
    }
}
