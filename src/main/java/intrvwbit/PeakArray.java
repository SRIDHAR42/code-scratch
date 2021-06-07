package intrvwbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PeakArray {

    public int perfectPeak(ArrayList<Integer> A) {
        // this is a comment
        ArrayList<Integer> left = new ArrayList<Integer>(A);

        ArrayList<Integer> right = new ArrayList<Integer>(A);
        int n = A.size();
        int max = left.get(0);

        for (int i = 1; i < n; i++) {
            if (left.get(i) > max) {
                max = left.get(i);
            } else {
                left.set(i, -1);
            }
        }

        int min = left.get(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            if (right.get(i) < min) {
                min = right.get(i);
            } else {
                right.set(i, -1);
            }
        }

        for (int i = 1; i < n-1; i++) {
            if (left.get(i) == right.get(i) && left.get(i)!= -1) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        PeakArray p = new PeakArray();
//        int i = p.perfectPeak(new ArrayList<>(Arrays.asList(
//                5706, 26963, 24465, 29359, 16828, 26501, 28146, 18468, 9962, 2996, 492, 11479, 23282, 19170, 15725, 6335)));
        int i = p.perfectPeak(new ArrayList<>(Arrays.asList(
                9488, 25784, 5652, 9861, 31311, 8611, 1671, 7129, 28183, 2743, 11059, 4473, 7927, 21287, 2259, 7214, 32529)));
        System.out.println(i);
    }
}
