package testNO;

import thread.LocalVars;
import thread.OperandStack;

public class testLocalVars {

    public static void main(String[] args) {
        OperandStack operandStack = new OperandStack(10);
        operandStack.pushT(12);
        int x = operandStack.popT();
        System.out.println(x);
        operandStack.pushD(12315123L);
        System.out.println((long)operandStack.popD());
        operandStack.pushT(13213.0F);
        System.out.println((float)operandStack.popT());
        operandStack.pushD(12312D);
        System.out.println((double)operandStack.popD());



        LocalVars localVars = new LocalVars(10);
        localVars.setT(0, 100);
        localVars.setT(1, -100);
        localVars.setD(2, 29123123L);
        localVars.setD(4, -1231321231L);
        localVars.setT(6,3.2131F);
        localVars.setD(7, 123123D);

        System.out.println((int)localVars.getT(0));
        System.out.println((int)localVars.getT(1));
        System.out.println((long)localVars.getD(2));
        System.out.println((long)localVars.getD(4));
        System.out.println((float)localVars.getT(6));
        System.out.println((double)localVars.getD(7));
    }

}
