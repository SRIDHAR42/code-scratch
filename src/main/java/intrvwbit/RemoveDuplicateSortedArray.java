package intrvwbit;


import java.util.ArrayList;
import java.util.Arrays;

//https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicateSortedArray {

    public int removeDuplicates(ArrayList<Integer> a) {
        int n = a.size();
        if (n == 0) return n;
        int res = 0;
        int i = 1;
        int curr = 0, next = 1;
        while (next < n) {
            if (a.get(next) == a.get(curr)) {
                next++;
            } else {
                a.set(i, a.get(next));
                i++;
                curr = next;
                next++;
                res++;
            }
        }
        System.out.println("returning " + a.get(res));
        return a.get(res);
    }

    public static void main(String[] args) {
        final RemoveDuplicateSortedArray ins = new RemoveDuplicateSortedArray();
        final int i = ins.removeDuplicates(new ArrayList<>(Arrays.asList(0)));
        System.out.println(i);
    }
}
