package LeetCode.hard;

public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        int slen = s.length();
        int tlen = t.length();
        String res = "";
        boolean found = false;

        int[] tArr = new int[128];
        for (int i = 0; i < tlen; i++) {
            tArr[t.charAt(i)]++;
            System.out.println("i " + t.charAt(i));
        }

        for(int i = 0; i < slen; i++) {
            for (int j = i; j < slen; j++) {
                if((j - i + 1) < t.length()) { // smaller string not possible
                    continue;
                }
                if (found && (j-i + 1) > res.length() ) { // current substring is greater than already got string
                    break;
                }
                int[] subArr = new int[128];
                for (int idx = i; idx <= j; idx++) { // include i and j
                    subArr[s.charAt(idx)]++;
                    System.out.println("added sub " + s.charAt(idx));

                }

                String sub = s.substring(i, j + 1); // since j is included
                System.out.println("checking s: " + sub + " t " + t );
                boolean exist = doesAnagramExist(subArr, tArr);
                System.out.println("checking s: " + sub + " t " + t + " exist " + exist);
                if (exist) {
                    found = true;
                    res = sub;
                }
            }
        }
        return res;
    }

    private boolean doesAnagramExist(int[] subArr, int[] tArr) {
        for (int i = 0; i < 128; i++) {
            if (subArr[i] > 0 || 0 < tArr[i])
                System.out.println("i " + i + " " + subArr[i] + " "  + tArr[i]);
            if (tArr[i] > subArr[i]) {
                System.out.println("returning false");
                return false;
            }
        }
        System.out.println("returning true ");
        return true;
    }

    public static void main(String[] args) {
        MinWindowSubstring obj = new MinWindowSubstring();
        final String res = obj.minWindow("ADOBECODEBANC", "ABC");
        System.out.println("final result is " + res);
    }
}
