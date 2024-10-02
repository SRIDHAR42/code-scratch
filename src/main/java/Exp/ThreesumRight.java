package Exp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class ThreesumRight {

    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        Set<ArrayList<Integer>> s = new HashSet<>();
        A.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        int n = A.size();
        int j, k;
        for (int i = 0; i < n; i++) {
            j = i + 1;
            k = n - 1;
            while (j < k) {
                // System.out.println(i + " " + j + " " + k);
                long sum = (long)A.get(i) + (long)A.get(j) + (long)A.get(k);
                // System.out.println("sum = " + sum);
                if (sum == 0) {
                    final ArrayList<Integer> list = new ArrayList<>();
                    list.add(A.get(i));
                    list.add(A.get(j));
                    list.add(A.get(k));
                    s.add(list);
                }
                if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        final ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (ArrayList<Integer> list : s) {
            res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {
        new ThreesumRight().threeSum(
                new ArrayList<>(Arrays.asList(-1 ,0, 1, 2, -1, -4))
        );
    }
}
