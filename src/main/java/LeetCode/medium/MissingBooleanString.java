package LeetCode.medium;

import java.util.HashSet;
import java.util.Set;

public class MissingBooleanString {

    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> exist = new HashSet<>();
        for (String num : nums) exist.add(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums[0].length(); i++) sb.append('0');
        if (!exist.contains(sb.toString())) {
            return sb.toString();
        }
        while (nextString(sb)) {
            if (!exist.contains(sb.toString())) return sb.toString();
        }
        return sb.toString();
    }

    private boolean nextString(StringBuilder sb) {
        int n = sb.length() - 1;
        boolean carry = false;
        if (sb.charAt(n) == '0') {
            sb.replace(n,n+1, "1");
            return true;
        } else {
            sb.replace(n,n+1, "0");
            carry = true;
        }
        n--;
        while (n >= 0) {
            if (!carry) return true;
            if (sb.charAt(n) == '0') {
                sb.replace(n,n+1, "1");
                return true;
            } else {
                sb.replace(n,n+1, "0");
            }
            n--;
        }
        return false;
    }

    public String findDifferentBinaryStringfinal(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i=0;i<nums.length;i++){
            ans.append(nums[i].charAt(i) == '0' ? '1' :'0');
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        MissingBooleanString ob = new MissingBooleanString();
        final String differentBinaryString = ob.findDifferentBinaryString(new String[]{"00","01", "10"});
        System.out.println("missing " + differentBinaryString);
    }
}

// https://leetcode.com/problems/find-unique-binary-string/?envType=daily-question&envId=2025-02-20
