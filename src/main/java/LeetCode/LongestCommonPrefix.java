package LeetCode;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix obj = new LongestCommonPrefix();
        System.out.println(obj.longestCommonPrefix(new String[]{"ab", "a"}));
//        System.out.println(obj.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
//        System.out.println(obj.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));

    }

    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        StringBuilder sb = new StringBuilder();
        if (n == 1) return strs[0];
        for (int i = 0; i < 200; i++) {
            char ch;
            if (i < strs[0].length()) {
                ch = strs[0].charAt(i);
            } else {
                return sb.toString();
            }
            for (int j = 1; j < n; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return sb.toString();
                }
            }
            sb.append(ch);
        }
        return sb.toString();
    }
}
