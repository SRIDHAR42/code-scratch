package Exp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ThreesumWrong {

    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        Set<Integer> mp = new HashSet<>();
        int i = 0, j, n = A.size();
        for (i = 0; i < n; i ++) {
            mp.add(A.get(i));
        }
        for (i = 0; i < n - 2; i++) {
            for (j = i + 1; j < n - 1; j++) {
                int twosum = A.get(i) + A.get(j);
                if (mp.contains(-1 * twosum)) {
                    Addtriplets(res, A.get(i), A.get(j), -1 * twosum);
                    mp.remove(-1 * twosum);
                }
            }
        }
        return res;
    }

    private void Addtriplets(ArrayList<ArrayList<Integer>> res, int i, int j, int k) {
        if (i <= j) {
            addTripInternal(res, i, j, k);
        } else {
            addTripInternal(res, j, i, k);
        }
    }

    private void addTripInternal(ArrayList<ArrayList<Integer>> res, int i, int j, int k) {
        if (k <= i) {
            addEntry(res, k, i, j);
        } else if (i <= k && k <= j) {
            addEntry(res, i, k, j);
        } else {
            addEntry(res, i, j, k);
        }
    }

    private void addEntry(ArrayList<ArrayList<Integer>> res, int i, int j, int k) {
        ArrayList<Integer> entry = new ArrayList<>();
        entry.add(i);
        entry.add(j);
        entry.add(k);
        res.add(entry);
    }
}

