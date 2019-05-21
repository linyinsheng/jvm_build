package thread;

public class OperandStack {
    Slot[] slots;
    int top;

    public OperandStack(int number) {
        slots = new Slot[number];
        for (int i = 0; i < number; i++) {
            slots[i] = new Slot();
        }
        top = 0;
    }


    public <T> void pushT(T t){
        slots[top++].value = t;
    }

    public <T> T popT(){
        return (T)slots[--top].value;
    }

    public <T> void pushD(T t){
        slots[top++].value = t;
        top++;
    }

    public <T> T popD(){
        top--;
        return (T)slots[--top].value;
    }


/**
    public void pushInt(int val){
        slots[top++].value = val;
    }

    public int popInt(){
        return (int) slots[--top].value;
    }

    public void pushFloat(int val){
        slots[top++].value = val;
    }

    public float popFloat(){
        return (float)slots[--top].value;
    }

    public void pushLong(long val){
        slots[top++].value = val;
        top++;
    }

    public long popLong(){
        --top;
        return (long)slots[--top].value;
    }

    public void pushDouble(double val){
        slots[top++].value = val;
        top++;
    }

    public double pop(){
        --top;
        return (double)slots[--top].value;
    }

**/
}
