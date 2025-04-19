package LeetCode.medium;

import java.util.Arrays;

public class CountNumberOfFairPair {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return countPairsWithSumLessThan(nums, upper + 1) - countPairsWithSumLessThan(nums, lower);
    }

    private long countPairsWithSumLessThan(int[] nums, int sum) {
        long count = 0;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int curr = nums[l] + nums[h];
            if (curr < sum) {
                count += (h - l);
                l++;
            } else {
                h--;
            }
        }
        return count;
    }
}

// https://leetcode.com/problems/count-the-number-of-fair-pairs
