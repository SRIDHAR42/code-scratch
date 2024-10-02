package Exp;

import java.util.HashMap;
import java.util.Map;

public class PrintMap {
    public static void main(String[] args) {
        Map<String, String> somethingMap = new HashMap<String, String>();
        somethingMap.put("hello","first key");
        somethingMap.put("bye","second key");
        System.out.println(somethingMap);
    }
}
