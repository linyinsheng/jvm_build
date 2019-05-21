package link.file.attribute;

import link.Read;
import link.file.constantsPool.Utf8Info;
import link.file.ClassFile;
import link.file.FieldInfo;
import link.file.MethodInfo;

import java.io.IOException;
import java.io.InputStream;

public class AttributeUtils {
    /**
     * 解析字段的属性表
     * @param in
     * @param fieldInfo
     * @param classFile
     * @throws IOException
     */
    public static void parseAttributes(InputStream in, FieldInfo fieldInfo, ClassFile classFile) throws IOException {
        short count = Read.readU2(in);
        fieldInfo.setAttributes_count(count);
        fieldInfo.setAttributes(new AttributeInfo[count]);
        for (int i = 0; i < count; i++) {
            fieldInfo.getAttributes()[i] = parseAttribute(in, classFile);
        }
    }


    /**
     * 解析方法的属性表
     * @param in
     * @param methodInfo
     * @param classFile
     * @throws IOException
     */
    public static void parseAttributes(InputStream in, MethodInfo methodInfo, ClassFile classFile) throws IOException {
        short count = Read.readU2(in);
        methodInfo.setAttributes_count(count);
        methodInfo.setAttributes(new AttributeInfo[count]);
        for (int i = 0; i < count; i++) {
            methodInfo.getAttributes()[i] = parseAttribute(in, classFile);
        }
    }

    /**
     * 解析属性(包括class文件的属性)
     * @param in
     * @param classFile
     * @return
     * @throws IOException
     */
    public static AttributeInfo parseAttribute(InputStream in, ClassFile classFile) throws IOException {
        short index = Read.readU2(in);
        Utf8Info utf8Info = (Utf8Info)classFile.getConstantsInfos()[index];
        String str = new String(utf8Info.getBytes());
        switch (str){
            case Attribute.CONSTANTVALUE:
                return parseConstantValue(in, index);
            case Attribute.CODE:
                return parseCode(in, index, classFile);
            case Attribute.LINENUMBERTABLE:
                return parseLineNumberTable(in, index);
            case Attribute.SOURCEFILE:
                return parseSourceFile(in, index);
            case Attribute.SIGNATURE:
                return parseSignature(in, index);
            case Attribute.STACKMAPTABLE:
                return parseStackMapTable(in, index);
            case Attribute.EXCEPTIONS:
                return parseExceptions(in, index);
            case Attribute.LOCALVARIABLETABLE:
                return parseLocalVariableTable(in, index);
            default:
                System.out.println(index);
                System.out.println(str);
                throw new IOException("属性未定义");
        }
    }

    private static AttributeInfo parseLocalVariableTable(InputStream in, short index) throws IOException {
        LocalVariableTableInfo localVariableTableInfo = new LocalVariableTableInfo();
        localVariableTableInfo.setAttribute_name_index(index);
        localVariableTableInfo.setAttribute_length(Read.readU4(in));
        localVariableTableInfo.setLocal_variable_table_length(Read.readU2(in));
        short[][] local_variable_table = new short[localVariableTableInfo.getLocal_variable_table_length()][5];
        for (int i = 0; i < local_variable_table.length; i++) {
            local_variable_table[i][0] = Read.readU2(in);
            local_variable_table[i][1] = Read.readU2(in);
            local_variable_table[i][2] = Read.readU2(in);
            local_variable_table[i][3] = Read.readU2(in);
            local_variable_table[i][4] = Read.readU2(in);
        }
        localVariableTableInfo.setLocal_variable_table(local_variable_table);
        return localVariableTableInfo;
    }

    static AttributeInfo parseExceptions(InputStream in, short index) throws IOException {
        ExceptionsInfo exceptionsInfo = new ExceptionsInfo();
        exceptionsInfo.setAttribute_name_index(index);
        exceptionsInfo.setAttribute_length(Read.readU4(in));
        exceptionsInfo.setNumber_of_exceptions(Read.readU2(in));
        exceptionsInfo.setException_index_table(new short[exceptionsInfo.getNumber_of_exceptions()]);
        for (int i = 0; i < exceptionsInfo.getException_index_table().length; i++) {
            exceptionsInfo.getException_index_table()[i] = Read.readU2(in);
        }
        return exceptionsInfo;
    }

    static AttributeInfo parseStackMapTable(InputStream in, short index) throws IOException {
        StackMapTableInfo stackMapTableInfo = new StackMapTableInfo();
        stackMapTableInfo.setAttribute_name_index(index);
        stackMapTableInfo.setAttribute_length(Read.readU4(in));
        stackMapTableInfo.setNumber_of_entries(Read.readU2(in));
//        System.out.println();
//        System.out.println(stackMapTableInfo.getAttribute_length());
        System.out.println(stackMapTableInfo.getNumber_of_entries());
        for (int i = 0; i < stackMapTableInfo.getAttribute_length()-2; i++) {
            int temp = in.read();
//            System.out.println(temp);
        }
        /**
         * 将来处理
         */
        System.out.println("StackMapTableInfo 没有写完，只是把数据输出掉而已");
        return stackMapTableInfo;
    }

    static AttributeInfo parseSignature(InputStream in, short index) throws IOException {
        SignatureInfo signatureInfo = new SignatureInfo();
        signatureInfo.setAttribute_name_index(index);
        signatureInfo.setAttribute_length(Read.readU4(in));
        signatureInfo.setSignature_index(Read.readU2(in));
        return signatureInfo;
    }

    static AttributeInfo parseSourceFile(InputStream in, short index) throws IOException {
        SoureFileInfo soureFileInfo = new SoureFileInfo();
        soureFileInfo.setAttribute_name_index(index);
        soureFileInfo.setAttribute_length(Read.readU4(in));
        soureFileInfo.setSourcefile_index(Read.readU2(in));
        return soureFileInfo;
    }

    static AttributeInfo parseLineNumberTable(InputStream in, short index) throws IOException {
        LineNumberTableInfo lineNumberTableInfo = new LineNumberTableInfo();
        lineNumberTableInfo.setAttribute_name_index(index);
        lineNumberTableInfo.setAttribute_length(Read.readU4(in));
        short count = Read.readU2(in);
        lineNumberTableInfo.setLine_number_table_length(count);
        lineNumberTableInfo.setLine_number_table(new short[count][2]);
        for (int i = 0; i < count; i++) {
            lineNumberTableInfo.getLine_number_table()[i][0] = Read.readU2(in);
            lineNumberTableInfo.getLine_number_table()[i][1] = Read.readU2(in);
        }
        return lineNumberTableInfo;
    }

    static AttributeInfo parseCode(InputStream in, short index, ClassFile classFile) throws IOException {
        CodeInfo codeInfo = new CodeInfo();
        codeInfo.setAttribute_name_index(index);
        codeInfo.setCode_length(Read.readU4(in));
        codeInfo.setMax_stack(Read.readU2(in));
        codeInfo.setMax_locals(Read.readU2(in));
        int length = Read.readU4(in);
        codeInfo.setCode_length(length);
        codeInfo.setCode(new byte[length]);
        for (int i = 0; i < length; i++) {
            codeInfo.getCode()[i] = (byte) in.read();
        }
        short count = Read.readU2(in);
        codeInfo.setException_table_length(count);
        codeInfo.setExceptionTables(new ExceptionTable[count]);
        for (int i = 0; i < count; i++) {
            codeInfo.getExceptionTables()[i].setStart_pc(Read.readU2(in));
            codeInfo.getExceptionTables()[i].setEnd_pc(Read.readU2(in));
            codeInfo.getExceptionTables()[i].setHandle_pc(Read.readU2(in));
            codeInfo.getExceptionTables()[i].setCatch_type(Read.readU2(in));
        }
        count = Read.readU2(in);
        codeInfo.setAttributes_count(count);
        codeInfo.setAttributes(new AttributeInfo[count]);
        for (int i = 0; i < count; i++) {
            codeInfo.getAttributes()[i] = parseAttribute(in, classFile);
        }
        return codeInfo;
    }

    static AttributeInfo parseConstantValue(InputStream in, short index) throws IOException {
        ConstantValueInfo constantsInfo = new ConstantValueInfo();
        constantsInfo.setAttribute_name_index(index);
        constantsInfo.setAttribute_length(Read.readU4(in));
        constantsInfo.setConstantvalue_index(Read.readU2(in));
        return constantsInfo;
    }
}
