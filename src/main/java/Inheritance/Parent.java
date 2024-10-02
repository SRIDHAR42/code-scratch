package Inheritance;

public class Parent {

    public void displayPublic() {
        System.out.println("Parent displayPublic called");
    }

    protected void displayProtected() {
        System.out.println("Parent displayProtected called");
    }

    private void displayPrivate() {
        System.out.println("Parent display called");
    }

    void displayDefault() {
        System.out.println("Parent displayDefault called");
    }
}
