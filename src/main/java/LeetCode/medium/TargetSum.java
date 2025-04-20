package LeetCode.medium;

public class TargetSum {
    int res = 0;

    public int findTargetSumWays(int[] nums, int target) {
        res = 0;
        helper(nums, 0, 0, target);
        return res;
    }

    private void helper(int[] nums, int idx, long sum, int target) {
        if (idx == nums.length) {
            if (sum == target) res++;
            return;
        }
        if (idx > nums.length) return;
        helper(nums, idx + 1, sum + nums[idx], target);
        helper(nums, idx + 1, sum - nums[idx], target);
    }
}

// https://leetcode.com/problems/target-sum/description
