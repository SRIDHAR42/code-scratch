package LeetCode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class CountCompleteSubArray {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> ss = new HashSet<>();
        for (int i : nums) {
            ss.add(i);
        }
        Map<Integer, Integer> mp = new HashMap<>();
        int i = 0, distinct = ss.size();
        int n = nums.length;
        int res = 0;
        for (int j = 0; j < n; j++) {
            int num = nums[j];
            mp.put(num, mp.getOrDefault(num, 0) + 1);
            while (mp.size() >= distinct) {
                res = res + (n - j);
                if (mp.get(nums[i]) == 1) {
                    mp.remove(nums[i]);
                } else {
                    mp.put(nums[i], mp.get(nums[i]) - 1);
                }
                i++;
            }

        }
        return res;
    }
}
// https://leetcode.com/problems/count-complete-subarrays-in-an-array