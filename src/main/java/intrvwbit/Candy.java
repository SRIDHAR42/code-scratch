package intrvwbit;

public class Candy {
    public int solve(int a, int b, int c) {
        System.out.println("a: " + a + " b: " + b + " c: " +c);
        int res = 0;
        a = a % b;
        res = (c + a - 1) % b;
        if (res == 0) {
            return b;
        }
        return res;
    }

    public static void main(String[] args) {
        for(int i =1;i<=10;i++){
            System.out.println(
                    new Candy().solve(i, 3, 2)
            );
        }

    }
}
