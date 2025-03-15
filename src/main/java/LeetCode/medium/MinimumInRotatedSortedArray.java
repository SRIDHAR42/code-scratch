package LeetCode.medium;

public class MinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int n = nums.length, l = 0, h = n -1;
        int mid = 0;
        while (l < h) {
            mid = l + (h -l) / 2;
            if (nums[mid] < nums[h]) {
                // mid...right is sorted
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return nums[l];
    }
}

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
