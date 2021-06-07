package intrvwbit;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallestElement {
    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        Stack<Integer> s = new Stack<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for ( int i = 0; i < n; i++) {
            int num = A.get(i);
            while (!s.empty() && s.peek() >= num) {
                s.pop();
            }
            if (s.empty()) {
                res.add(-1);
            } else {
                res.add(s.peek());
            }
            s.push(num);
        }
        return res;
    }
}
