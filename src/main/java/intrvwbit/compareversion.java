package intrvwbit;

public class compareversion {
    public int compareVersion(String a, String b) {
        int x = a.length(), y = b.length();
        int res = 0;
        int i = 0, j = 0;
        boolean startA = true, startB = true;
        while (i < x && j < y ) {

            //trailing 0 need to be removed
            while (startA && i < x && a.charAt(i) == '0' ) i++;
            startA = false;
            while (startB && j < y && b.charAt(j) == '0' ) j++;
            startB = false;

            char c;
            if (i < x){
                 c = a.charAt(i);
            } else {
                return -1;
            }
            char d;
            if (j < x){
               d = b.charAt(j);
            } else {
                return 1;
            }


            if (c == d){
                if (c == '.') {
                    startA = true;
                    startB = true;
                }
            } else if (c == '.') {
                return -1;
            } else if (d == '.') {
                return 1;
            } else if (c > d) {
                return 1;
            } else {
                return -1;
            }

            i++;
            j++;
        }
        if (i < x) { //string a is bigger
            return 1;
        }
        if (j < y) { //b is bigger
            return -1;
        }
        return 0;
    }


    public static void main(String[] args) {
        compareversion ins = new compareversion();
        System.out.println(ins.compareVersion("13.0", "13.0.8"));
    }

}
