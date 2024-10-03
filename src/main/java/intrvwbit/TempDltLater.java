package intrvwbit;

import java.util.ArrayList;
import java.util.Arrays;

public class TempDltLater {

    public int diffPossible(ArrayList<Integer> A, int B) {
        int n = A.size();
        int i = 0;
        int j = n - 1;
        int diff;
        for (i = 0; i < n-1; i++) {
            j = n-1;
            while(i < j) {
                System.out.println(i + " " + j);
                diff = A.get(j) - A.get(i);
                if (diff == B) {
                    return 1;
                } else if (diff < B) {
                    break;
                } else {
                    j--;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        new TempDltLater().diffPossible(new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4)), 0);
    }
}
