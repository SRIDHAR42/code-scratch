package LeetCode.medium;

import java.util.*;
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        int num = 0;
        for (int i = 1; i < nums.length; i++) {
            num = nums[i];
            if (num > temp.get(temp.size() -1)) {
                temp.add(num);
            } else {
                int idx = getInsertIndex(temp, num);
                temp.set(idx, num);
            }
        }
        return temp.size();
    }

    private int getInsertIndex(List<Integer> temp, int num) {
        // using binary search we find insert index as temp will be sorted
        int l = 0, h = temp.size() - 1;
        int mid = 0;
        while (l <= h) {
            mid = (l + h)/2;
            if (num > temp.get(mid)) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return (num > temp.get(mid)) ? mid + 1 : mid;
    }

    public static void main(String[] args) {
        final LongestIncreasingSubsequence ob = new LongestIncreasingSubsequence();
        final int i = ob.lengthOfLIS(new int[]{0, 1, 0, 3, 2, 3, 0, 1});
        System.out.println("res " + i);
    }
}
