package LeetCode;

public class AddBinaryNumbers {
    public static void main(String[] args) {
        AddBinaryNumbers obj = new AddBinaryNumbers();
        obj.addBinary("11", "1");
        obj.addBinary("1010", "1011");
    }

    public String addBinary(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        String res = "";
        int carry = 0;
        int curr;
        char aChar, bChar;
        int n = Math.max(alen, blen);
        for (int i = 0; i < n; i++) {
            // get characters
            aChar = (i < alen) ? a.charAt(alen - 1 - i) : '0';
            bChar = (i < blen) ? b.charAt(blen - 1 - i) : '0';
            System.out.println("checking " + aChar + " " + bChar);

            curr = 0;
            if (aChar == '1') {
                curr++;
            }
            if (bChar == '1') {
                curr++;
            }
            curr += carry;
            res = ((curr % 2 == 0) ? "0" : "1") + res;
            carry = (curr > 1) ? 1 : 0;
        }
        if (carry == 1) {
            res = "1" + res;
        }
        System.out.println("res " + res);
        return res;
    }
}
