package LeetCode;

import java.util.ArrayList;

public class PermutationInString {

    Boolean found;
    public boolean checkInclusion(String s1, String s2) {
        found = false;
        if (s2.contains(s1)) return true;
        ArrayList<Character> charList = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            charList.add(s1.charAt(i));
        }
        helper("", s2, charList);
        return found;
    }

    private void helper(String curr, String s2, ArrayList<Character> charList) {
        // exit
        if (found) return;
        if (charList.size() == 0 && s2.contains(curr))  {
            System.out.println("checking " + curr);
            found = true;
            return;
        }
        for (int i = 0; i < charList.size() && !found; i++) {
            ArrayList<Character> tmp = new ArrayList<>(charList);
            tmp.remove(i);
            helper(curr + charList.get(i), s2, tmp);
        }
    }

    public static void main(String[] args) {
        PermutationInString obj = new PermutationInString();
        final boolean b = obj.checkInclusion("ab", "eidbaooo");
        System.out.println("found " + b);
    }
}

// https://leetcode.com/problems/permutation-in-string/?envType=problem-list-v2&envId=plakya4j
