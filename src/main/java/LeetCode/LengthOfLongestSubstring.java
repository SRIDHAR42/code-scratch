package LeetCode;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring obj = new LengthOfLongestSubstring();
        System.out.println(obj.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(obj.lengthOfLongestSubstring("bbbbb"));
        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
    }
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        for (int i =0; i<n; i++) {
            int[] visited = new int[256];
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                if (visited[ch] == 1) {
                    break;
                }
                res = Math.max(res, j - i + 1);
                visited[ch] = 1;
            }
        }
        return res;

    } // https://leetcode.com/problems/longest-substring-without-repeating-characters/
}
