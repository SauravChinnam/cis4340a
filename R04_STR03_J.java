import java.math.BigInteger;


public class R04_STR03_J {

    public static void main(String[] args) {

        BigInteger y = new BigInteger("530500452766");
        String str = y.toString();
        byte[] byteArray2 = str.getBytes();
        String ns = new String(byteArray2);
        y = new BigInteger(ns);
        System.out.println("Compliant BigInteger: " + y);
    }
}
