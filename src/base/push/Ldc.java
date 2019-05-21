package base.push;

import base.Instruction;
import link.file.constantsPool.ConstantsInfo;
import memory.Metaspace;
import thread.Frame;
import thread.JVMThread;

import java.util.Map;

public class Ldc implements Instruction {

    private Ldc(){    }

    private static Ldc instance = new Ldc();

    public static Ldc getInstance(){
        return instance;
    }

    @Override
    public void execute(Frame frame, JVMThread JVMThread, byte[] codes) {
        int index = codes[frame.pc++];
        Map<String, ConstantsInfo> constantsInfoMap = Metaspace.getInstance().getConstantsInfoMap();
        ConstantsInfo constantsInfo = constantsInfoMap.get(frame.className + "." + index);
        frame.operandStack.pushT(constantsInfo);
    }
}
