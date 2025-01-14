package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        for (int n : nums) {
            num.add(n);
        }
        helper(num, res, new ArrayList<>(), 0, nums.length);
        return res;
    }

    private void helper(List<Integer> nums, List<List<Integer>> res, List<Integer> curr, int idx, int n) {
        if (curr.size() == n) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (idx > n) return;

        // each element of nums gets to be added  in curr
        for (int i = 0; i < nums.size(); i++) {
            curr.add(nums.get(i));
            List<Integer> tmp = new ArrayList<>(nums);
            tmp.remove(i);
            helper(tmp, res, curr, idx + 1, n);
            curr.remove(curr.size() -1);
        }
    }

    public static void main(String[] args) {
        Permutations obj = new Permutations();
        obj.permute(new int[]{1,2,3});
    }
}
