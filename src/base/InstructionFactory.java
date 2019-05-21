package base;

import base.If.Goto;
import base.If.If_Icmple;
import base.add.IAdd;
import base.consts.*;
import base.load.ILoad_0;
import base.load.ILoad_1;
import base.load.ILoad_2;
import base.load.ILoad_3;
import base.push.Bipush;
import base.push.Ldc;
import base.push.Sipush;
import base.store.*;

public class InstructionFactory {
    public static Instruction instruction(byte code){
        switch (code){
            case 0:
                return Nop.getInstance();
            case 1:
                return AConst_null.getInstance();
            case 2:
                return IConst_m1.getInstance();
            case 3:
                return IConst_0.getInstance();
            case 4:
                return IConst_1.getInstance();
            case 5:
                return IConst_2.getInstance();
            case 6:
                return IConst_3.getInstance();
            case 7:
                return IConst_4.getInstance();
            case 8:
                return IConst_5.getInstance();
            case 9:
                return LConst_0.getInstance();
            case 10:
                return LConst_1.getInstance();
            case 11:
                return FConst_0.getInstance();
            case 12:
                return FConst_1.getInstance();
            case 13:
                return FConst_2.getInstance();
            case 14:
                return DConst_0.getInstance();
            case 15:
                return DConst_1.getInstance();
            case 16:
                return Bipush.getInstance();
            case 17:
                return Sipush.getInstance();
            case 18:
                return Ldc.getInstance();
            case 26:
                return ILoad_0.getInstance();
            case 27:
                return ILoad_1.getInstance();
            case 28:
                return ILoad_2.getInstance();
            case 29:
                return ILoad_3.getInstance();

            case 58:
                return AStore.getInstance();
            case 60:
                return IStore_1.getInstance();
            case 61:
                return IStore_2.getInstance();
            case 75:
                return AStore_0.getInstance();
            case 76:
                return AStore_1.getInstance();
            case 77:
                return AStore_2.getInstance();
            case 78:
                return AStore_3.getInstance();
            case 96:
                return IAdd.getInstance();

            case -79:
                return Nop.getInstance();
            case -89:
                return Goto.getInstance();
            case -92:
                return If_Icmple.getInstance();
        }
        // 27 16 100 96 61 28 16 100 -92 0 8 5 61 -89 0 5 4 61 -79
        System.out.println(code);
        return null;
    }
}
