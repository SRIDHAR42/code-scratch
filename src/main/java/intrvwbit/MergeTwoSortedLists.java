package intrvwbit;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeTwoSortedLists {
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int m = b.size();
        int i = 0;
        int j = 0;
        while (i < a.size() && j < m) {
            if (a.get(i) > b.get(j)) { // b element needs to be added in ith pos
                a.add(i, b.get(j));
                i++;
                j++;
            } else { // a element is equal or smaller
                i++;
            }
        }
        while (j < m) {
            a.add(b.get(j));
            j++;
        }
    }

    public static void main(String[] args) {
        final MergeTwoSortedLists ins = new MergeTwoSortedLists();
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 5, 8));
        ArrayList<Integer> B = new ArrayList<>(Arrays.asList(1,5,8));
        ins.merge(A, B);
        for (Integer integer : A) {
            System.out.print(integer + " ");
        }

    }
}
