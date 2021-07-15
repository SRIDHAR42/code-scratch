package intrvwbit;

public class ExcelColumnNameToNumber {
    public int titleToNumber(String A) {
        int pow =0;
        int res = 0;
        for (int i =A.length() -1; i >= 0; i--) {
            char ch = A.charAt(i);
            res = res + (int) (Math.pow(26,pow) * ((int) ch - 64) ) ;
            pow++;
        }
        return res;
    }

    public static void main(String[] args) {
        ExcelColumnNumber e = new ExcelColumnNumber();
        ExcelColumnNameToNumber ee = new ExcelColumnNameToNumber();
        for (int i =0; i<101; i++) {
            System.out.println(e.solve(i) + " " + ee.titleToNumber(e.solve(i)) );
        }
    }
}
