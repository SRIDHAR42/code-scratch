package intrvwbit.TwoPtr;

public class PalindromeString {

    public static void main(String[] args) {
        System.out.println(new PalindromeString().isPalindrome("A man, a plan, a canal: Panama"));
    }

    public int isPalindrome(String A) {
        int i,j, n = A.length();
        Character ichar, jchar;
        i = 0;
        j = n-1;
        while (i < j) {
            i = getNextChar(A, n, i);
            j = getPrevChar(A, n, j);
            ichar = Character.toUpperCase(A.charAt(i));
            jchar = Character.toUpperCase(A.charAt(j));
//            System.out.println("Comparing " + ichar + ":" + jchar);
            if ( i > (n-1) || j < 0 || ichar != jchar) {
                return 0;
            } else {
//                System.out.println(Character.toUpperCase(A.charAt(i)));
//                System.out.println(Character.toUpperCase(A.charAt(j)));

            }
            i++;
            j--;
        }
        return 1;
    }

    public int getNextChar(String A,int n, int i) {
        while (!isValid((int) A.charAt(i)) && i < n ){
            i++;
        }
        if (i == n) return -1;
        return i;
    }

    public int getPrevChar(String A, int n, int i) {
        while (!isValid((int) A.charAt(i)) && i >= 0 ){
            i--;
        }
        if (i == -1) return -1;
        return i;
    }

    public boolean isValid(int ch) {
        boolean valid = ( (ch >= 48 && ch <=57 ) ||
                        (ch >=65 && ch <= 90) ||
                        (ch >= 97 && ch <= 122) );
//        System.out.println("char :" + (char)ch + ": is valid " + valid );
        return valid;

    }
}
