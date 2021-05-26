public class StringHashCode {

    public static void main(String[] args) {
        for (int i=0;i<10;i++) {
            String s = getStringThingy();
            System.out.println("hash of string s is " + s.hashCode());
        }

    }

    private static String getStringThingy() {
        return new String("Sridhar");
    }
}
