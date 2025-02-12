package LeetCode.easy;

import java.util.Map;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> mp = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!s.isEmpty() && s.peek() < nums2[i]) {
                int top = s.pop();
                mp.put(top, nums2[i]);
            }
            s.push(nums2[i]);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            Integer val = mp.get(nums1[i]);
            ans[i] = (val != null) ? val : -1;
        }

        return ans;

    }
}

// https://leetcode.com/problems/next-greater-element-i/