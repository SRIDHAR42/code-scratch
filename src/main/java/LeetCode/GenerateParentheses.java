package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(0, 0, n, new ArrayList<>(), res);
        return res;
    }

    public void helper(int open, int close, int n, List<Character> curr,List<String> res) {
        // exit condition
        if (open > n || close > n || close > open) {
            return;
        }

        // valid
        if (open == n && close == n) {
            System.out.println("open " + open + " close " + close);
            res.add(makeString(curr));
            return;
        }

        curr.add('(');
        helper(open + 1, close, n, curr, res);
        curr.remove(curr.size() - 1);
        curr.add(')');
        helper(open, close + 1, n, curr, res);
        curr.remove(curr.size() - 1);
    }

    public String makeString(List<Character> curr) {
        StringBuilder sb = new StringBuilder();
        for (Character character : curr) {
            sb.append(character);
        }
        System.out.println(sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        GenerateParentheses obj = new GenerateParentheses();
        final List<String> stringList = obj.generateParenthesis(3);
        System.out.println(stringList);
    }

}

// medium
// https://leetcode.com/problems/generate-parentheses/description/?envType=problem-list-v2&envId=plakya4j
