package LeetCode;

public class HappyNumber {

    public boolean isHappy(int n) {
        int slow = n;
        int fast = sumSq(n);
        while (slow != fast) {
            slow = sumSq(slow);
            fast = sumSq(sumSq(fast));
        }
        return slow == 1;
    }

    private int sumSq(int n) {
        int res = 0;
        while (n > 0) {
            res = res + (int) Math.pow(n % 10,2);
            n = n/10;
        }
        return res;
    }

    public static void main(String[] args) {
        new HappyNumber().isHappy(19);
    }


}
//https://leetcode.com/problems/happy-number/?envType=problem-list-v2&envId=plakya4j&difficulty=EASY
