package intrvwbit;

import java.util.Map;
import java.util.HashMap;

public class NonRepeatingCharacters {

    public String solve(String A) {
        String res = "";
        Map<Character, Integer> mp = new HashMap<Character, Integer>();
        int index = 0;
        for (int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            //update map
            if ( mp.containsKey(c) ) {
                mp.put(c, mp.get(c) + 1);
            } else {
                mp.put(c, 1);
            }

            // check FNRC
            while(index < i && mp.get( A.charAt(index) ) > 1 ) {
                index ++;
            }

            if (mp.get(A.charAt(index)) == 1) {
                res += (A.charAt(index));
            } else { 	//add to res
                res += '#';
            }
        }
        return res;

    }

    public static void main(String[] args) {
        NonRepeatingCharacters ins = new NonRepeatingCharacters();
        System.out.println(ins.solve("abcabc"));
    }
}
