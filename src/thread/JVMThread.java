package thread;

import link.ResolutionUtils;
import link.file.MethodInfo;
import link.file.attribute.AttributeInfo;
import link.file.attribute.CodeInfo;
import memory.Metaspace;

import java.io.IOException;
import java.util.Map;
import java.util.Stack;

public class JVMThread {
    private String method = null;
    public Stack stack;
    public Frame top;

    public JVMThread(){
        top = null;
    }

    public void execute(String method) throws IOException {
        Metaspace metaspace = Metaspace.getInstance();
        String className = method.substring(0, method.lastIndexOf("."));
        System.out.println(className);/**打印**/
        Map<String, MethodInfo> methodInfoMap = metaspace.getMethodInfoMap();
        if (!methodInfoMap.containsKey(method)){
            ResolutionUtils.resolution(className);
        }
        byte[] codes = null;
        CodeInfo codeInfo = null;
        MethodInfo methodInfo = methodInfoMap.get(method);
        AttributeInfo[] attributes = methodInfo.getAttributes();
        for (int i = 0; i < attributes.length; i++) {
            if (attributes[i] instanceof CodeInfo){
                codeInfo = (CodeInfo) attributes[i];
                codes = codeInfo.getCode();
                break;
            }
        }
        top = new Frame(codeInfo.getMax_stack(), codeInfo.getMax_locals(), top, className);
        top.execute(codes, this);
        System.out.println("线程结束");
    }
}
