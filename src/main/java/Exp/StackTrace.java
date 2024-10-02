package Exp;

public class StackTrace {
    public static void main(String[] args) {
        while(true) {
            method1();
        }
    }

    private static void method1() {
        while(true) {
            method2();
        }
    }

    private static void method2() {
        method3();
    }

    private static void method3() {
        logStackTrace();
    }

    private static void logStackTrace() {
        String stackTrace = "";
        final StackTraceElement[] stackTrace1 = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace1) {
            stackTrace += stackTraceElement.toString();
            stackTrace += '\n';
        }
        System.out.println(stackTrace);
        System.out.println();
        System.out.println();
        sleep(2000);
    }

    private static void sleep(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
