package intrvwbit;

import java.util.ArrayList;
import java.util.List;

public class MaxSumContiguousSubarray {

    public int maxSubArray(final List<Integer> A) {
        int n = A.size();
        if (n == 1) {
            return A.get(0);
        }
        int max_here = 0, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max_here = max_here + A.get(i);

            if (max < max_here) {
                max = max_here;
            }

            // this needs to be here because for all negative values
            // we need to return minimum
            if (max_here < 0) {
                max_here = 0;
            }

        }
        return max;
    }
}
