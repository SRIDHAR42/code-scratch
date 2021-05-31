package intrvwbit;

import java.util.ArrayList;

public class AddOneToNumber {

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        boolean carry = false;
        if (A.get(n - 1) == 9) {
            ans.add(0, 0);
            carry = true;
        } else {
            ans.add(0, A.get(n-1) +1);
        }
        for (int i = n - 2; i >= 0; i--) {
            if (carry) {
                if (A.get(i) == 9) {
                    ans.add(0, 0);
                    carry = true;
                } else {
                    ans.add(0, A.get(i) + 1);
                    carry = false;
                }
            } else {
                ans.add(0, A.get(i));
            }
        }
        if (carry) {
            ans.add(0, 1);
        }
        //remove 0
        while( ans.size() > 0) {
            if (ans.get(0) == 0) {
                ans.remove(0);
            } else {
                break;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(0);
        a.add(9);
        a.add(9);
        a.add(9);
        System.out.println("ans: " + new AddOneToNumber().plusOne(a));
    }
}
