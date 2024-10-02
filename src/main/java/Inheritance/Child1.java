package Inheritance;

public class Child1 extends Parent{

    public void Child1displayPublic() {

        System.out.println("Parent Child1displayDefault called");
    }

    protected void Child1displayProtected() {
        displayProtected();
        System.out.println("Parent Child1displayDefault called");
    }

    private void Child1displayPrivate() {
        System.out.println("Parent Child1displayDefault called");
    }

    void Child1displayDefault() {
        System.out.println("Parent Child1displayDefault called");
    }

    public static void main(String[] args) {
        final Child1 ins = new Child1();
        ins.displayDefault();
        ins.displayProtected();
        ins.displayPublic();
    }
}
