package intrvwbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class BookPageStudentMax {
//    https://www.interviewbit.com/problems/allocate-books/

    public ArrayList<Integer> pg;

    public void initPg(ArrayList<Integer> A) {
        pg = new ArrayList<Integer>(A);
        for (int i=1;i<A.size();i++) {
            pg.set(i, pg.get(i) + pg.get(i-1));
        }
    }

    public int studentNeed(ArrayList<Integer> A, int ind) {

        return (int) Math.ceil(
                (double) A.get(A.size()-1 ) / A.get(ind)
                );
    }

    public int books(ArrayList<Integer> A, int B) {

        int low = 0, high = A.size()-1, mid;
        mid = (high + 1)/2;
        int stud = -1;
        Collections.sort(A);
        initPg(A);
        // binary to set number of pages.
        while (low<high) {
            mid = (high + 1)/2;
            stud = studentNeed(A,mid);
//            System.out.println("stud  = " + stud + " mid = " + mid);
            if( stud > B  ){ // stud need to read more
                low = mid - 1;
            } else if ( stud < B) { // stud can read less
                high = mid + 1;
            } else {
                break;
            }
        }
        if (stud == B && pg != null) {
            return  pg.get(mid);
        }
        return -1;
    }


    public static void main(String[] args) {
        final ArrayList<Integer> integers = new ArrayList<>();
        final int red = new BookPageStudentMax().books(new ArrayList<Integer>(Arrays.asList(12, 34, 67, 90)), 2);
        System.out.println("res " + red);
    }
}
