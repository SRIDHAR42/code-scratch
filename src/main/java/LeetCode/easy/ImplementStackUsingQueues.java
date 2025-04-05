package LeetCode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    Queue<Integer> q1;
    Queue<Integer> q2;
    Queue<Integer> temp;

    public ImplementStackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.add(x);
    }

    public int pop() {
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        int res = q1.poll();
        temp = q1;
        q1 = q2;
        q2 = temp;
        return res;
    }

    public int top() {
        int res = pop();
        push(res);
        return res;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

// https://leetcode.com/problems/implement-stack-using-queues/description/
