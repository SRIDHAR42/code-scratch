package Exp;

public class Parent {

    int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public void finalize() throws Exception {
        templogger.log(this + " parent class garbage collected ");
    }
    public static final LogToFileLAVAISHN templogger =  new LogToFileLAVAISHN("Exp.Parent",true);


}
