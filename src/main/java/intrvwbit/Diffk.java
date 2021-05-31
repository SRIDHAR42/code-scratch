package intrvwbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Diffk {
    public int diffPossibleMap(ArrayList<Integer> A, int B) {
        int res = 0;
        Map<Integer,Integer> m = new HashMap<Integer,Integer>();

        for (int i = 0; i<A.size(); i++) {
            if(m.get(A.get(i)+B) != null || m.get(A.get(i)- B) != null) {
                return 1;
            }
            m.put(A.get(i),i);
        }
        return res;
    }

    public int diffPossible(ArrayList<Integer> A, int B) {
        int i=0, j=1;
        while ( i<j && j<A.size()) {
            if(A.get(j) - A.get(i) < B) {
                j++;
            } else if (A.get(j) - A.get(i) > B) {
                i++;
            } else {
                return 1;
            }
            if( i == j) {
                j++;
            }
        }
        return 0;
    }
}

