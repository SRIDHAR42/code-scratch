package LeetCode.medium;

import java.util.Arrays;

public class MinOperationToMakeUniGrid {

    public int minOperations(int[][] grid, int x) {
        int[] nums = new int[grid.length * grid[0].length];
        int i, j, idx = 0;
        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[0].length; j++) {
                nums[idx++] = (grid[i][j]);
            }
        }

        Arrays.sort(nums);
        for (i = 0; i < nums.length; i++) {
            // check if can make that number in using x
            if ((nums[i] - nums[0]) % x != 0) return -1;
        }
        int median = nums[nums.length / 2];
        int res = 0;
        for (i = 0; i < nums.length; i++) {
            res += Math.abs(nums[i] - median) / x;
        }
        return res;
    }

}

//https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/description/
