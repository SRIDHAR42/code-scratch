package intrvwbit;

import java.util.ArrayList;

public class VowelndConsonantSubstrings {

    public int solve(String A) {
        int mod = (int) Math.pow(10,9) +7;

        int n = A.length();
        int res = 0, vow = 0, con = 0;
        if (isVowel(A.charAt(n-1))) {
            vow++;
        } else {
            con++;
        }
        for (int i =n-2; i >=0; i--) {
            if (isVowel(A.charAt(i))) {
                res = (res + con ) % mod;
                vow++;
            } else {
                res = (res + vow) % mod;
                con++;
            }
        }

        return res;
    }



    public int subSt(String A) {
        int n = A.length();
        ArrayList<Integer> vow = new ArrayList<Integer>();
        ArrayList<Integer> con = new ArrayList<Integer>();
        int res = 0;

        if (isVowel(A.charAt(n-1))) {
            vow.add(1);
            con.add(0);
        } else {
            con.add(1);
            vow.add(0);
        }
        for (int i = n-2; i>=0; i--) {
            if (isVowel(A.charAt(i))) {
                vow.add(0, vow.get(0) + 1);
                con.add(0, 0);
            } else {
                con.add(0, con.get(0) + 1);
                vow.add(0,0);
            }
        }

        for (int i = 0; i < n-1; i++) {
            if (isVowel(A.charAt(i))) {
                res += con.get(i+1);
            } else {
                res += vow.get(i+1);
            }
        }

        return res;

    }

    private boolean isVowel(char c) {
        return ( c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
    }


    public static void main(String[] args) {
        VowelndConsonantSubstrings ins = new VowelndConsonantSubstrings();
        System.out.println(ins.subSt("aba"));
    }
}
