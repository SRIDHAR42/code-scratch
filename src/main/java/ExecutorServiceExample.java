
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.currentThread;

public class ExecutorServiceExample {


    public static void main(String[] args) {
        System.out.println("Main started: " + new Date() + " Name:" + currentThread().getName());

        final ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Method started: " + new Date() + " Name:" + currentThread().getName());
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Exiting");
                System.out.println("Method exit: " + new Date() + " Name:" + currentThread().getName());
            }
        });
        executorService.shutdown();
        System.out.println("Method exit: " + new Date() + " Name:" + currentThread().getName());


        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main started: " + new Date() + " Name:" + currentThread().getName());
    }
}
