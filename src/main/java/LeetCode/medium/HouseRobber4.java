package LeetCode.medium;

public class HouseRobber4 {
    public int minCapability(int[] nums, int k) {
        int low = nums[0];
        int high = nums[0];
        for (int i = 0; i < nums.length; i++) {
            low = Math.min(nums[i], low);
            high = Math.max(nums[i], high);
        }

        int res = 0, midValue = 0;
        while (low <= high) {
            midValue = low + (high - low)/2;
            if (possible(nums, k, midValue)) {
                res = midValue;
                high = midValue - 1;
            } else {
                low = midValue + 1;
            }
        }
        return res;
    }

    private boolean possible(int[] nums, int k, int midValue) {
        // System.out.println("checking for : "  + midValue);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= midValue) {
                k--;
                i++;
            }
            if (k <= 0) return true;
        }
        // System.out.println("return false for : "  + midValue);
        return false;
    }
}
// https://leetcode.com/problems/house-robber-iv/description/
