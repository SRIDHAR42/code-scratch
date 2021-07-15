package intrvwbit;

import java.lang.*;
import java.util.*;

public class dltlater {
}


class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            if (valid(str)) {
                System.out.println('1');
            } else {
                System.out.println('0');
            }
        }
    }

    private static boolean valid(String str) {
        Stack<Character> stack;
        int flag = 0;
        stack = new Stack<Character>();
        for (int j = 0; j < str.length(); j++) {
            char c = str.charAt(j);
            if (c == '(') {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty()) {
                flag = 1;
                break;
            }
            if (c == ')') {
                stack.pop();
            }
        }
        if (stack.isEmpty() && flag == 0) {
            return true;
        }
        return false;
    }
}
