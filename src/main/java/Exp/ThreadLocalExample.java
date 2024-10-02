package Exp;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

public class ThreadLocalExample {

    private static final java.lang.ThreadLocal<Deque<Integer>> TLS =
            new java.lang.ThreadLocal<Deque<Integer>>() {
                @Override
                public Deque initialValue() {
                    return new ConcurrentLinkedDeque();
                }
            };

    public static void pushInteger(final Integer span) {
        Deque<Integer> stack = TLS.get();
        stack.offerFirst(span);
    }

    public static Integer popInteger() {
        Integer span = null;
        Deque<Integer> stack = TLS.get();
        try {
            span = stack.pop();
        } finally {
            if (stack.isEmpty()) {
                // clean up threadlocal variable value
                TLS.remove();
            }
        }

        return span;
    }

    public static Integer peek() {
        System.out.println(TLS.get().toString());
        Deque<Integer> stack = TLS.get();
        return stack.peek();
    }
}
