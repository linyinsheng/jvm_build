package thread;

public class LocalVars {
    Slot[] slots;

    public LocalVars(int number) {
        slots = new Slot[number];
        for (int i = 0; i < number; i++) {
            slots[i] = new Slot();
        }
    }

    public <T> void  setT(int index, T t){
        slots[index].value = t;
    }

    public <T> T getT(int index){
        return (T)slots[index].value;
    }

    public <T> void setD(int index, T t){
        slots[index].value = t;
    }

    public <T> T getD(int index){
        return (T)slots[index].value;
    }

}
