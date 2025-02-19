package LeetCode.medium;

import java.util.Set;
import java.util.TreeSet;

public class KthLexicographicallyHappyString {
    int k;
    char[] c = new char[]{'a', 'b', 'c'};

    public String getHappyString(int n, int k) {
        this.k = k;
        Set<String> happySet = new TreeSet<>();
        helper(n, happySet, "");
        // for (String s : happySet) {
        //     System.out.println(s);
        // }
        int idx = 1;
        for (String s : happySet) {
            if (idx++ == k) return s;
        }
        return "";
    }

    private void helper(int n, Set<String> happySet, String curr) {
        if (curr.length() > n || happySet.size() > k) return;
        if (curr.length() == n) {
            happySet.add(curr);
            return;
        }

        for (char ch : c) {
            if (curr.length() == 0 || curr.charAt(curr.length() -1) != ch) {
                helper(n, happySet, curr + ch);
            }
        }
    }
}
