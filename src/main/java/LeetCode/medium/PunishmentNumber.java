package LeetCode.medium;

public class PunishmentNumber {
    private boolean canMake(int i, int sq) {
        System.out.println("inside canMake " + i + " sq " + sq);
        // return true if sq can be partitioned in such a way that sum is i
        if (i == sq) return true;
        if (sq < i) return false;
        boolean res = false;
        int num = 0;
        int count = 0;
        while(sq != 0 && !res) {
            num =  ((sq % 10) *  (int)Math.pow(10,count++)) + num; // num 3, 23, 123 ...
            sq = sq / 10;
            if (i >= num) {
                System.out.println("calling " + (i - num) + " sq " + sq);
                res = canMake(i - num, sq);
            } else {
                return false;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        PunishmentNumber ob = new PunishmentNumber();
        final boolean b = ob.canMake(36, 1296);
        System.out.println("final res " + b);
    }
}
