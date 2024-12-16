package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum obj = new ThreeSum();
        final List<List<Integer>> lists = obj.threeSum(new int[]{-2,0,1,1,2});
        System.out.println(lists);
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        int n = nums.length;
        List<Integer> listArr = new ArrayList<>();
        for (int num : nums) {
            listArr.add(num);
        }
        Collections.sort(listArr);
        System.out.println(listArr);
        for (int i = 0; i < n; i++) {
            int j = i + 1; // index of smaller num
            int k = n - 1; // index of greater num
            while (j < k) {
                long sum = listArr.get(i) + listArr.get(j) + listArr.get(k);
                System.out.println("checking " + listArr.get(i) + " " +  listArr.get(j) + " " + listArr.get(k));
                if (sum == 0) {
                    List<Integer> entry = new ArrayList<Integer>();
                    entry.add(listArr.get(i));
                    entry.add(listArr.get(j));
                    entry.add(listArr.get(k));
                    res.add(entry);
                    j++;
                } else if (sum < 0) {
                    j++; // we need a greater sum
                } else {
                    k--; // we need a smaller sum
                }
            }
        }
        return new ArrayList<List<Integer>>(res);
    }
}
