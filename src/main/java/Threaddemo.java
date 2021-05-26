public class Threaddemo {
    public static void main(String[] args) {
        startThreadRecursively();
    }

    private static void startThreadRecursively() {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true)
               printhello();
            }
        });
        t.start();
    }

    private static void printhello() {
        System.out.println("hello");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
