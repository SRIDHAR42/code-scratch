package Exp;

import java.util.Random;

import static java.lang.Thread.sleep;

public class ThreadLocalTest {

    public static void main(String[] args) {
        for (int i =0; i< 5; i++){
            customSleep(1);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    doThreadLocalWork();
                }
            }).start();
        }
    }

    private static void customSleep(int i) {
        try {
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void doThreadLocalWork() {
        ThreadLocalExample.peek();
        final int rand = new Random().nextInt();
        ThreadLocalExample.pushInteger(rand);
        final Integer integer = ThreadLocalExample.popInteger();
        System.out.println("popped integer is " +integer);
    }
}
