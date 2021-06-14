package contest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class QueenPair {
    public int solve(ArrayList<Integer> A) {
        int n = A.size();
        int res = 0;
        int frnd;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i = 0; i < n; i++) {
            frnd = A.get(i) -1;
            if (frnd > i && A.get(frnd) == i+1 ){
                res++;
            }
        }
        return res;
    }
}
