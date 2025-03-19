package LeetCode.medium;

public class MinOperationToMakeBinaryElementEqualToOne {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int flip = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                // flip
                flip++;
                nums[i] = 1;
                if (i + 1 < n) {
                    nums[i + 1] = (nums[i + 1] == 0) ? 1: 0;
                } else {
                    return -1;
                }
                if (i + 2 < n) {
                    nums[i + 2] = (nums[i + 2] == 0) ? 1: 0;
                } else {
                    return -1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) return -1;
        }

        return flip;
    }
}

// https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/