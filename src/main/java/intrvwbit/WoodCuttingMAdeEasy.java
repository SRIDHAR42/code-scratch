package intrvwbit;

import java.util.ArrayList;

public class WoodCuttingMAdeEasy {
    public int getHeight(ArrayList<Integer> A, int target) {
        //logic : do  a binary search and find out optimal tree height.
        int low = 0;
        int high = maxHeight(A);
        int mid;
        int cur = 0, res = 0;

        //binary
        while(low <= high) {
            mid = (low + high) /2;
            cur = getTreeCut(A, mid);
            if ( cur > target) { // got more tree; need less tree; increase height
                res = mid;
                low = mid + 1;
            } else if (cur < target) { // less tree; need more tree; to decrease height
                high = mid - 1;
            } else { // exact amount; we have got the answer
                return mid;
            }
        } //end loop

        return res;
    } // end func


    public int getTreeCut(ArrayList<Integer> A, int h) {
        int res = 0;
        for (int i = 0; i < A.size(); i++) {
            res += Math.max(0, A.get(i) -h);
        } // end for
        return res;
    } // endF

    public int maxHeight(ArrayList<Integer> A) {
        int height = 0;
        for (int i = 0; i < A.size(); i++) {
            height = Math.max(height, A.get(i));
        } // end for
        return height;
    }


}
