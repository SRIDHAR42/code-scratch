package LeetCode.easy;

import java.util.Stack;

public class ImplementQueueUsingStack {

    Stack<Integer> s1;
    Stack<Integer> s2;

    public ImplementQueueUsingStack() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void push(int x) {
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
        s1.push(x);
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
    }

    public int pop() {
        return s2.pop();
    }

    public int peek() {
        return s2.peek();
    }

    public boolean empty() {
        return s2.isEmpty();
    }

}

// https://leetcode.com/problems/implement-queue-using-stacks/description/
