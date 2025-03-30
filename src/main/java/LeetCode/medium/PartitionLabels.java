package LeetCode.medium;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] lastIndex = new int[128];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i)] = i;
        }
        int start = 0, end = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            int idx = lastIndex[s.charAt(i)];
            if (idx > end) end = idx;
            if (i == end) { // till here all char last index is present
                // so this is a valid partition
                res.add(end - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}

// https://leetcode.com/problems/partition-labels/description/
