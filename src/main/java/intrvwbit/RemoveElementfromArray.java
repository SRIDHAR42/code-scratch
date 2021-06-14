package intrvwbit;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveElementfromArray {
    public int remove(ArrayList<Integer> A, int B) {
        int n = A.size();
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (A.get(i) != B) {
                A.set(j, A.get(i));
                i++;
                j++;
            } else {
                i++;
            }
        }
        System.out.println(A);
        System.out.println(j + 1);
        return (j + 1);
    }

    public static void main(String[] args) {
        RemoveElementfromArray r = new RemoveElementfromArray();
        r.remove(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 1, 1, 2, 1, 3, 4)), 1);
    }
}
