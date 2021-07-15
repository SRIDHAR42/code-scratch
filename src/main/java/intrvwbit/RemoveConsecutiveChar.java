package intrvwbit;

public class RemoveConsecutiveChar {

    public String solve(String s, int b) {
        int n = s.length();
        char chP = s.charAt(0), ch;
        int indP = 0 ;
        int count = 1;
        String res = "";
        for (int i = 1; i < n; i++) {
            ch = s.charAt(i);
            if (chP == ch) {
                count++;
            } else {
                if (count != b) { // not add
                    res = res.concat(s.substring(indP, i)) ;

                }
                chP = ch;
                indP = i;
                count = 1;
            }
        }
        if ( count != b) {
            res = res.concat(s.substring(indP, n));
        }

        return res;
    }


    public static void main(String[] args) {
        RemoveConsecutiveChar ins = new RemoveConsecutiveChar();
        System.out.println(ins.solve("aabbcccddeeffff", 2));
    }
}
