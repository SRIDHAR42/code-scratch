package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.equals("")) return res;

        String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
                "tuv", "wxyz"};
        helper(digits, res, 0, "", mapping);
        return res;
    }

    public void helper(String digits,List<String> res,int idx, String curr, String[] mapping) {
        if (idx == digits.length()) {
            // finished all
            res.add(curr);
            return;
        }
        int digit = (int) digits.charAt(idx) - 48;
        String chars = mapping[digit];
        for (int i = 0; i < chars.length(); i++) {
            helper(digits, res, idx + 1, curr + chars.charAt(i), mapping);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsPhoneNumber obj = new LetterCombinationsPhoneNumber();
        obj.letterCombinations("23");
    }
}
