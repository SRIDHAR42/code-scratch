package intrvwbit.Trees.dlt_later;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MiscProblem {
    //     * Definition for binary tree
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }


    public static void main(String[] args) {

    }

    public int perfectPeak(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(0);
        }
        int temp = A.get(0);
        for (int i = 1; i< n; i++) {
            // temp is current max
            // if A.get(i) is greater than max then ith ele is strictly greater than all left element
            if (A.get(i) > temp ) {
                arr.set(i, 1);
                temp = A.get(i); // new max
            }
        }

        temp = A.get(n-1);
        for (int i = n-2; i >=0; i--) {
            // temp is current min
            // if A.get(i) is less than min then ith ele is strictly less than all right element
            if (A.get(i) < temp) {
                arr.set(i, arr.get(i) + 1);
                temp = A.get(i); // new min
            }
        }

        // element will be 2 once for left it and once for right ite.
        for (int i = 1; i <n-1; i++) {
            if (arr.get(i) == 2) return 1;
        }
        return 0;
    }


}
