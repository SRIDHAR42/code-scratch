package LeetCode.medium;

public class SmallestNumberFromDIString {
    String ans;
    public String smallestNumber(String pattern) {
        int[] used = new int[10];
        for (int i = 1; i <= 9; i++) {
            ans = "" + i;
            used[i] = 1;
            if (backtrack(pattern, 0, ans, used)) return ans;
            used[i] = 0;
        }
        return ans;

    }

    private boolean backtrack(String pattern, int idx, String ans, int[] used) {
        if (idx == pattern.length()) {
            this.ans = ans;
            return true;
        }
        char c = pattern.charAt(idx);
        int i = ans.charAt(ans.length() -1) - '0';
        if (c == 'I') {
            for (int b = i + 1; b <=9; b++) {
                if (used[b] == 1) continue;
                used[b] = 1;
                if (backtrack(pattern, idx + 1, ans + b, used)) return true;
                used[b] = 0;
            }
        } else {
            for (int b = 1; b < i; b++) {
                if (used[b] == 1) continue;
                used[b] = 1;
                if (backtrack(pattern, idx + 1, ans + b, used)) return true;
                used[b] = 0;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        SmallestNumberFromDIString ob = new SmallestNumberFromDIString();
        ob.smallestNumber("IIIDIDDD");

    }
}
