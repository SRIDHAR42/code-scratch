package intrvwbit;

public class ExcelColumnNumber {
    public String solve(int a) {
        String res = "";
        while(a > 0) {
            long last = a % 26;
            res = getStringforNum(last).concat(res);
            if (last == 0) {
                a = a/26 -1;
            } else {
                a = a/26;
            }
        }
        return res;
    }

    public String getStringforNum(long i) {
        if ( i == -1) return "";
        else if ( i == 0 ) return "Z";
        return "" + (char) (64 + i);
    }


    public static void main(String[] args) {
        ExcelColumnNumber e = new ExcelColumnNumber();
        for (int i =26; i<=26; i++) {
            System.out.println(i + " " + e.solve(i));
        }
    }
}
