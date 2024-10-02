package Exp;

public class Conc  extends ProB {

    public void disp() {
        System.out.println(feild1 + 10);
    }


    public static void main(String[] args) {
        new Conc().printFeild();
        new Conc().disp();
    }
}
