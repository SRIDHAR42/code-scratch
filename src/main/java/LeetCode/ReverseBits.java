package LeetCode;

import java.util.ArrayList;

public class ReverseBits {

    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        ArrayList<Integer> bits = new ArrayList<>();
        while (n != 0) {
            bits.add(n % 2);
            n = n/2;
        }
        while (bits.size() < 32) {
            bits.add(0);
        }
        System.out.println("bits : " + bits);
        System.out.println("bits size : " + bits.size());
        int res = 0;
        for(int  i = 31; i >= 0; i--) {
            if (bits.get(i) == 1) {
                res += Math.pow(2, 31 - i);
//                System.out.println(res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ReverseBits obj = new ReverseBits();
        final int res = obj.reverseBits(79);
        System.out.println("res for  " + res);
        System.out.println("res for res " + res);
    }
}

// https://leetcode.com/problems/reverse-bits/description/?envType=problem-list-v2&envId=plakya4j
