package link.file.constantsPool;

import link.Read;
import link.file.ClassFile;

import java.io.IOException;
import java.io.InputStream;

public class ConstantsUtils {

    /**
     * 解析常量池
     * @param in
     * @param classFile
     * @throws IOException
     */
    public static void parseConstantPool(InputStream in, ClassFile classFile) throws IOException {
        short count = Read.readU2(in);
        classFile.setConstant_pool_count(count);
        classFile.setConstantsInfos(new ConstantsInfo[count]);
        for (int i = 1; i < count; ) {
            i = parseConstant(in, i, classFile);
        }

    }

    /**
     * 解析常量
     * @param in
     * @param index
     * @param classFile
     * @return
     * @throws IOException
     */
    static int parseConstant(InputStream in, int index, ClassFile classFile) throws IOException {
        int tag = in.read();
        ConstantsInfo constantsInfo = null;
        switch (tag){
            case Constants.CONSTANT_Class:
                constantsInfo = parseClass(in); break;
            case Constants.CONSTANT_Fieldref:
                constantsInfo = parseFieldref(in);  break;
            case Constants.CONSTANT_InterfaceMethodref:
                constantsInfo = parseInterfaceMethodref(in); break;
            case Constants.CONSTANT_Methodref:
                constantsInfo = parseMethodref(in); break;
            case Constants.CONSTANT_String:
                constantsInfo = parseString(in);    break;
            case Constants.CONSTANT_Utf8:
                constantsInfo = parseUtf8(in); break;
            case Constants.CONSTANT_NameAndType:
                constantsInfo = parseNameAndType(in);   break;
            case Constants.CONSTANT_Integer:
                constantsInfo = parseInteger(in); break;
            case Constants.CONSTANT_Float:
                constantsInfo = parseFloat(in); break;
            case Constants.CONSTANT_Double:
                constantsInfo = parseDouble(in);    break;
            case Constants.CONSTANT_Long:
                constantsInfo = parseLong(in);  break;
            case Constants.CONSTANT_MethodHandle:
            case Constants.CONSTANT_InvokeDynamic:
            case Constants.CONSTANT_MethodType:
            default:
                System.err.println("没有解决的常量");
        }
        classFile.getConstantsInfos()[index] = constantsInfo;
        if (tag == Constants.CONSTANT_Double || tag == Constants.CONSTANT_Long){
            index++;
        }
        return index+1;
    }

    static ConstantsInfo parseFloat(InputStream in) throws IOException {
        FloatInfo floatInfo = new FloatInfo();
        floatInfo.setBytes(Read.readU4(in));
        return floatInfo;
    }

    static ConstantsInfo parseInteger(InputStream in) throws IOException {
        IntegerInfo integerInfo = new IntegerInfo();
        integerInfo.setBytes(Read.readU4(in));
        return integerInfo;
    }

    static ConstantsInfo parseDouble(InputStream in) throws IOException {
        DoubleInfo doubleInfo = new DoubleInfo();
        doubleInfo.setHigh_bytes(Read.readU4(in));
        doubleInfo.setLow_bytes(Read.readU4(in));
        return doubleInfo;
    }

    static ConstantsInfo parseLong(InputStream in) throws IOException {
        LongInfo longInfo = new LongInfo();
        longInfo.setHigh_bytes(Read.readU4(in));
        longInfo.setLow_bytes(Read.readU4(in));
        return longInfo;
    }

    static ConstantsInfo parseNameAndType(InputStream in) throws IOException {
        NameAndTypeInfo nameAndTypeInfo = new NameAndTypeInfo();
        nameAndTypeInfo.setName_index(Read.readU2(in));
        nameAndTypeInfo.setDescriptor_index(Read.readU2(in));
        return nameAndTypeInfo;
    }

    /**
     * 编码问题暂未解决，Ascll码可以使用
     * @param in
     * @return
     * @throws IOException
     */
    static ConstantsInfo parseUtf8(InputStream in) throws IOException {
        Utf8Info utf8Info = new Utf8Info();
        short length = Read.readU2(in);
        utf8Info.setLength(length);
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            bytes[i] = (byte) in.read();
        }
        utf8Info.setBytes(bytes);
        utf8Info.setName(new String(bytes));
        return utf8Info;
    }

    static ConstantsInfo parseString(InputStream in) throws IOException {
        StringInfo stringInfo = new StringInfo();
        stringInfo.setString_index(Read.readU2(in));
        return stringInfo;
    }


    static ConstantsInfo parseClass(InputStream in) throws IOException {
        ClassInfo classInfo = new ClassInfo();
        classInfo.setName_index(Read.readU2(in));
        return classInfo;
    }


    static ConstantsInfo parseFieldref(InputStream in) throws IOException {
        FieldrefInfo fieldrefInfo = new FieldrefInfo();
        fieldrefInfo.setClass_index(Read.readU2(in));
        fieldrefInfo.setName_and_type_index(Read.readU2(in));
        return fieldrefInfo;
    }

    static ConstantsInfo parseInterfaceMethodref(InputStream in) throws IOException {
        InterfaceMethodrefInfo interfaceMethodrefInfo = new InterfaceMethodrefInfo();
        interfaceMethodrefInfo.setClass_index(Read.readU2(in));
        interfaceMethodrefInfo.setName_and_type_index(Read.readU2(in));
        return interfaceMethodrefInfo;
    }

    static ConstantsInfo parseMethodref(InputStream in) throws IOException {
        MethodrefInfo methodrefInfo = new MethodrefInfo();
        methodrefInfo.setClass_index(Read.readU2(in));
        methodrefInfo.setName_and_type_index(Read.readU2(in));
        return methodrefInfo;
    }

}
