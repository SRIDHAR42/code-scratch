package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram obj = new ValidAnagram();
//        final List<List<String>> lists = obj.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
//        System.out.println(lists);
        System.out.println(obj.isPalindrome("OP"));
    }

    public boolean isPalindrome(String s) {
        s = sanitize(s);
        int i = 0;
        int n = s.length();
        if (n == 0) return true;
        while (i < n) {
            if (s.charAt(i) != s.charAt(n-1 -i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    public String sanitize(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i =0; i < n; i++) {
            int diff = s.charAt(i) - 'a';
            if (diff >= 0 && diff < 26) {
                sb.append(s.charAt(i));
            }
            diff = s.charAt(i) - 'A';
            if (diff >= 0 && diff < 26) {
                char ch = (char)('a' + diff);
                sb.append(ch);
            }

        }
        return sb.toString();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return res;
        }
        List<String> stringList = new ArrayList<>(Arrays.asList(strs));
        int i;
        while(stringList.size() > 0) {
            String fist = stringList.get(0);
            List<String> anagramSet = new ArrayList<>();
            anagramSet.add(fist);
            for (i = 1; i < stringList.size(); i++) {
                if (isAnagram(fist, stringList.get(i))) {
                    anagramSet.add(stringList.get(i));
                }
            }
            for (String setString : anagramSet) {
                stringList.remove(setString);
            }
            res.add(anagramSet);
        }
        return res;
    } // https://leetcode.com/problems/group-anagrams/description/ (medium)

    public boolean isAnagram(String s, String t) {
//        System.out.println("checking " + s + " " + t );
        if (s.length() != t.length()) return false;
        if (s.equals(t)) return true;
        int n = s.length();
        int count = 0;
        int[] charCount = new int[26];
        // for (int i = 0; i < 26; i++) {
        //     charCount[i] = 0;
        // }
        for (int i =0; i < n; i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (charCount[i] != 0) {
                return false;
            }

        }
        return true;
    } // https://leetcode.com/problems/valid-anagram/
}
