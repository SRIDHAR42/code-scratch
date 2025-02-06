package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int prod = nums[i] * nums[j];
                Integer count = mp.get(prod);
                if (count != null) {
                    res += 8 * count;
                    mp.put(prod, count + 1);
                } else {
                    mp.put(prod, 1);
                }
            }
        }

        return res;
    }
}
