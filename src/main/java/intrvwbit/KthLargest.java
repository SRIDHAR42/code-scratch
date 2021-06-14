package intrvwbit;

import java.util.ArrayList;
import java.util.Arrays;

public class KthLargest {

    public static void main(String[] args) {
        KthLargest ins = new KthLargest();
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(11, 3, 4));
        list = ins.kthArray(list , 2);
        System.out.println(list);
    }

    public ArrayList<Integer> kthArray(ArrayList<Integer> A, int K) {
        int n = A.size();
        ArrayList<Integer> res = new ArrayList<Integer>();
        for ( int i = 0; i < n; i++) {
            addToKthArray(res, A.get(i));
            if (res.size() > K) {
                res.remove(0);
            }
        }
        return res;
    }

    public void addToKthArray(ArrayList<Integer> res, int ele) {
        /**
         * 1. find the pos
         * 2. insert in the pos
         */
        int s = res.size();
        if ( s == 0) {
            res.add(ele);
            return;
        }
        int low = 0, high = s-1;
        int mid = 0;
        while ( low <= high) {
            mid = (low + high) / 2;
            if (ele < res.get(mid) ) {
                high = mid - 1;
            } else if (ele > res.get(mid)) {
                low = mid + 1;
            } else {
                break;
            }
        }
        if (ele <= res.get(mid)) { //new is the mid
            res.add(mid, ele);
        } else { // new pos is mid + 1
            res.add(mid + 1, ele);
        }
    }
}
