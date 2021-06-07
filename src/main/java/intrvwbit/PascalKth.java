package intrvwbit;

import java.util.ArrayList;

public class PascalKth {
    public ArrayList<Integer> getRow(int A) {
        if (A < 0) return null;
        ArrayList<Integer> ar1 = new ArrayList<Integer>(A+1);
        ArrayList<Integer> ar2 = new ArrayList<Integer>(A+1);
        ArrayList<Integer> temp;

        for (int i = 0; i < A+1; i++) {
            ar1.add(0);
            ar2.add(0);
        }

        ar1.set(0,1);
        int i = 1;
        while(i <= A) {
            //populate j elements
            ar2.set(0,1);
            for (int j = 1; j<i; j++) {
                ar2.set( j, ar1.get(j) + ar1.get(j-1) );
            }
            ar2.set(i,1);

            // swap
            temp = ar1;
            ar1 = ar2;
            ar2 = temp;

            i++;
        }
        // ith row is aet to ar1;
        return ar1;
    }


    public static void main(String[] args) {
        System.out.println(new PascalKth().getRow(2));

    }
}
