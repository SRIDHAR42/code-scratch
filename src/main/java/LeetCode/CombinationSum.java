package LeetCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CombinationSum {

    Set<List<Integer>> res;
    Map<Integer, Set<List<Integer>>> mem;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new HashSet<>();
        mem = new HashMap<>();
        final Set<List<Integer>> list = comb(candidates, target);
        return new ArrayList<>(list);
    }

    private Set<List<Integer>> comb(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        if (target <= 0) return res;
        int n = candidates.length;
        if (mem.containsKey(target)) return mem.get(target);
        for (int i = 0; i < n; i++) {
            if (candidates[i] <= target) {
                final Set<List<Integer>> list = comb(candidates, target - candidates[i]);
                if (list.size() == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(candidates[i]);
                    Collections.sort(temp);
                    res.add(temp);
                }
                for (List<Integer> integers : list) {
                    List<Integer> temp = new ArrayList<>(integers);
                    temp.add(candidates[i]);
                    Collections.sort(temp);
                    res.add(temp);
                }
            }
        }

        Set<List<Integer>> res1 = new HashSet<>();
        for (List<Integer> row : res) {
            int num = 0;
            for (Integer integer : row) {
                num += integer;
            }
            if (num == target) {
                res1.add(row);
            }
        }


        mem.put(target, res1);
        System.out.println("found for " + target + " res " + res1);
        return res1;
    }

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates, target, res, 0, 0, new ArrayList<>());
        return res;
    }

    private void helper(int[] candidates, int target, List<List<Integer>> res, int idx, int sum, List<Integer> comb) {
        // exit condition
        if (sum == target) {
            // valid set
            res.add(new ArrayList<>(comb));
            return;
        }
        if (idx >= candidates.length || sum > target) {
            return;
        }
        // assuming idx is a part of soln
        comb.add(candidates[idx]);
        helper(candidates, target, res, idx, sum + candidates[idx], comb);
        comb.remove(comb.size() - 1);
        helper(candidates, target, res, idx + 1, sum, comb);

    }


        public static void main(String[] args) {
        CombinationSum obj = new CombinationSum();
//        final List<List<Integer>> list = obj.combinationSum(new int[]{2, 3, 5}, 8);
        final List<List<Integer>> list = obj.combinationSum1(new int[]{2, 3, 5}, 8);
        for (List<Integer> integers : list) {
            System.out.println("row: " + integers);
        }
    }
} // medium prob
// https://leetcode.com/problems/combination-sum/?envType=problem-list-v2&envId=plakya4j
