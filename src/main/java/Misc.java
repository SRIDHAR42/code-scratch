import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Misc {

    public static ArrayList<Long> infoTime =  new ArrayList();
    public static Long[] debugTime = new Long[1000];


    public static void main(String[] args) {
        int i=1;
        while(i++ <10000){
            infoTime.add(i *1L);
//            sleep();
        }
        for (Long aLong : infoTime) {
            System.out.println(" element " + aLong);

        }

    }

    private static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
