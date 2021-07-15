package intrvwbit;

public class FindNthFibonacci {
    public int fib(int a) {
        int f1 = 1, f2 = 1;
        int res = 1;
        int i = 2;
        int mod = (int) (Math.pow(10,9) + 7);
        if (a < 3) return res;
        while (i++ < a) {
            res = (f1 + f2 ) % mod;
            f1 = f2;
            f2 = res;
        }
        return res;
    }

    public static void main(String[] args) {
        FindNthFibonacci ins = new FindNthFibonacci();
        for (int i = 1; i<11; i++) {
            System.out.println("i:  " + i + " val:" + ins.fib(i));
        }
    }
}
