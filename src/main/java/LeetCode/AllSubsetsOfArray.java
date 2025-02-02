package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsOfArray {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums, res,new ArrayList<>(), 0);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res,List<Integer> curr, int idx) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if (idx > nums.length) return;
        //add the num
        curr.add(nums[idx]);
        helper(nums, res, curr, idx + 1);
        curr.remove(curr.size() - 1);
        helper(nums, res, curr, idx + 1);
    }
}
