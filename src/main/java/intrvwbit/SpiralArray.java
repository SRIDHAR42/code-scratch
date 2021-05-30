package intrvwbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SpiralArray {
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (A == null || A.isEmpty()) {
            return res;
        }
        int m = A.size();
        int n = A.get(0).size();
        int dir = 0;
        int ind = 0;
        int i = 0, j = 0;

        int imin = 0, imax = m, jmin = 0, jmax = n;
        while (ind < (m * n)) {
            res.add(A.get(i).get(j));
            ind++;
            if (dir == 0) { //  going right: increase j
                if(j != jmax-1){
                    j++;
                } else {
                    dir = (dir + 1) % 4;
                    jmax--;
                    i++;
                }

            } else if (dir == 1) { // going down increase i
                if (i != imax-1) {
                    i++;
                } else {
                    dir = (dir + 1) % 4;
                    imax--;
                    j--;
                }

            } else if (dir == 2) { // going left: j decreasing
                if (j != jmin) {
                    j--;
                } else {
                    dir = (dir + 1) % 4;
                    jmin++;
                    i--;
                }

            } else { //going up:
                if (i != imin) {
                    i--;
                } else {
                    dir = (dir + 1) % 4;
                    imin++;
                    j++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralArray sp = new SpiralArray();
        final ArrayList<Integer> iList = new ArrayList<>(Arrays.asList(1, 2));
        final ArrayList<Integer> iList2 = new ArrayList<>(Arrays.asList(3, 4));
        final ArrayList<Integer> iList3 = new ArrayList<>(Arrays.asList(5, 6));
        List<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
        A.add(iList);
        A.add(iList2);
        A.add(iList3);
        sp.spiralOrder(A);
    }
}
