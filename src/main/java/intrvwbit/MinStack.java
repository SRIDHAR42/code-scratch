package intrvwbit;

import java.util.Stack;

public class MinStack {
    Stack<Integer> st = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();

    public void push(int x) {
        st.push(x);
        if (min.isEmpty() || x < getMin()){
            min.push(x);
        }
    }

    public void pop() {
        int x;
        if(!st.isEmpty()) {
            x = st.pop();
            if (!min.isEmpty() && min.peek() == x) {
                min.pop();
            }
        }

    }

    public int top() {
        return (st.isEmpty())? -1:st.peek();
    }

    public int getMin() {
        return (min.isEmpty())? -1: min.peek();
    }
}
