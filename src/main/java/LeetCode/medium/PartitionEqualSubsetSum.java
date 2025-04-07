package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        PartitionEqualSubsetSum ob = new PartitionEqualSubsetSum();
        ob.canPartition(new int[]{1, 5, 11, 5});

    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        Set<Integer> temp;

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) return false;

        int target = sum / 2;
        int num;
        s1.add(0);
        for (int i = 0; i < n; i++) {
            num = nums[i];
            for (int j : s1) {
                if (j + num <= target) {
                    s2.add(j + num);
                }
            }
            s2.addAll(s1);
            if (s2.contains(target)) return true;
            temp = s1;
            s1 = s2;
            s2 = temp;
            s2.clear();
        }
        return s1.contains(target);
    }
}

// https://leetcode.com/problems/partition-equal-subset-sum/description/