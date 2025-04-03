package LeetCode.medium;

public class MaxValueOfOrderedTriplet2 {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            pre[i] = max;
            max = Math.max(max, nums[i]);
        }
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            suf[i] = max;
            max = Math.max(max, nums[i]);
        }

        long res = 0;
        for (int i = 1; i < n - 1; i++) {
            res = Math.max(res, 1L * (pre[i] - nums[i]) * suf[i]);
        }
        return res;
    }
}

// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/description/
