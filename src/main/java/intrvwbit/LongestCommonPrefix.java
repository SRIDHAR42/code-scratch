package intrvwbit;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestCommonPrefix {

    public String lcp(String[] A) {
        String prefix = A[0];
        for (int i = 1; i < A.length; i++) {
            while (A[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    public String longestCommonPrefix( ArrayList<String> s) {
        int i = 0;
        while (valid(s, i)) {
            i ++;
        }
        return s.get(0).substring(0,i);
    }

    public boolean valid(ArrayList<String> s, int ind) {
        int llen = s.size();
        char ch;
        if (s.get(0).length() > ind) {
            ch = s.get(0).charAt(ind);
        } else {
            return false;
        }
        for (int i = 1; i < llen; i++) {
            if (s.get(i).length() <= ind || s.get(i).charAt(ind) != ch) {
                return false;
            }
        }
        return true;
    }

    public static void main(String []arg) {
        LongestCommonPrefix ins = new LongestCommonPrefix();
//        String s = ins.findLCP(new ArrayList(Arrays.asList("abcde", "abc", "abldkhnas", "ababab" )) );
//        System.out.println(s);
    }


}
