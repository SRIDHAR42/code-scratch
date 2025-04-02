package LeetCode.easy;

public class MaxValueOfOrderedTriplet {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long temp, res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    temp = 1L * nums[k] * (nums[i] - nums[j]);
                    res = Math.max(res, temp);
                }
            }
        }
        return res;
    }
}
// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/
