package LeetCode.medium;

import java.util.List;

public class MinIndexOfValidSplit {
    public int minimumIndex(List<Integer> nums) {
        int dom = findDom(nums);
        if (dom == -1) return -1;
        int leftcount = 0, domCount = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == dom) domCount++;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == dom) leftcount++;

            int leftSub = leftcount;
            int rightSubDom = domCount - leftSub;
            if (leftSub > (i + 1) / 2 &&
                    rightSubDom > (nums.size() - 1 - i) / 2) {
                return i;
            }
        }

        return -1;
    }

    private int findDom(List<Integer> nums) {
        int cand = -1, count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (cand == nums.get(i)) {
                count++;
            } else if (count == 0) {
                cand = nums.get(i);
                count = 1;
            } else {
                count--;
            }
        }

        int tot = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == cand) {
                tot++;
            }
        }

        return (tot > nums.size() / 2) ? cand : -1;
    }
}

// https://leetcode.com/problems/minimum-index-of-a-valid-split/description/
