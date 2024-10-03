package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class PlusOne {

    public static void main(String[] args) {
        PlusOne obj = new PlusOne();
        final int[] ints = obj.plusOne(
                new int[]{1,2}
//                new int[]{9, 9, 9}
        );
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if (digits[n-1] != 9) {
            digits[n-1]++;
            return digits;
        }
        // List<Integer> streamListlistOld = Arrays.stream(digits).boxed().collect(Collectors.toList());
        List<Integer> listNum = new ArrayList<Integer>(digits.length);
        for (int i : digits) {
            listNum.add(i);
        }
        boolean carry = true;
        int i = listNum.size() - 1;
        while (carry && i >= 0) {
            if (listNum.get(i) == 9) {
                listNum.set(i, 0);
                i--;
            } else {
                carry = false;
                listNum.set(i, listNum.get(i) + 1);
            }
        }
        if (carry) {
            listNum.add(0, 1);
        }

        int[] res = new int[listNum.size()];
        for (i = 0; i < listNum.size(); i++) {
            res[i] = listNum.get(i);
        }

//        System.out.println(listNum);

        return res;

    }
}
