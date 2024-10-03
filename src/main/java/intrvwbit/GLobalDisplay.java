package intrvwbit;

import java.util.ArrayList;

public class GLobalDisplay {
    public static void displayArray(ArrayList<Integer> A) {
        System.out.print("[ ");
        for (int i = 0; i< A.size(); i++) {
            System.out.print(A.get(i) + ", ");
        }
        System.out.println("]");
    }
}
