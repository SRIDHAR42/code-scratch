package LeetCode.medium;

public class MaximumAbsSumOfAnySubArray {
    public int maxAbsoluteSum(int[] nums) {
        int res = 0;
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total = total + nums[i];
            res = Math.max(res, total);
            if (total < 0) {
                total = 0;
            }
            nums[i] = -1 * nums[i];
        }
        total = 0;
        res = Math.max(res, total);
        for (int i = 0; i < nums.length; i++) {
            total = total + nums[i];
            // System.out.println("total " + total);
            if (total < 0) {
                total = 0;
            }
            res = Math.max(res, total);

        }
        return res;
    }
}

// https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/?envType=daily-question&envId=2025-02-26
// 1749. Maximum Absolute Sum of Any Subarray
