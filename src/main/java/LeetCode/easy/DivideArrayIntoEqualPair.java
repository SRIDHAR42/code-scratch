package LeetCode.easy;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

public class DivideArrayIntoEqualPair {
    public boolean divideArray(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        Integer val = 0;
        for(int i = 0; i < nums.length; i++) {
            val = mp.get(nums[i]);
            if (val == null) mp.put(nums[i], 1);
            else {
                mp.put(nums[i], val + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
            if (entry.getValue() % 2 != 0) return false;
        }
        return true;
    }
}
