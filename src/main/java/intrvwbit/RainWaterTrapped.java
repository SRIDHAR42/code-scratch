package intrvwbit;

import java.util.ArrayList;


public class RainWaterTrapped {

    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();

        left.add(A.get(0)); //init
        for (int i = 1; i < n; i++) {
            left.add(Math.max(A.get(i), left.get(i - 1)));
        }
        right.add(A.get(n - 1)); // init
        for (int i = n - 2; i >= 0; i--) {
            right.add(0, Math.max(A.get(i), right.get(0)));
        }

        int res = 0;
        int ele; // curr elevation
        for (int i = 0; i < n; i++) {
            ele = Math.min(left.get(i), right.get(i));
            res += ele - A.get(i);
        }
        return res;
    }

}
