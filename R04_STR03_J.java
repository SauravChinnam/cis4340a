import java.math.BigInteger;


public class R04_STR03_J {

    public static void main(String[] args) {

        BigInteger x = new BigInteger("530500452766");
        byte[] byteArray = x.toByteArray();
        String s = new String(byteArray);
        byteArray = s.getBytes();
        x = new BigInteger(byteArray);
        System.out.println("Noncompliant BigInteger: " + x);


        BigInteger y = new BigInteger("530500452766");
        String str = y.toString();
        byte[] byteArray2 = str.getBytes();
        String ns = new String(byteArray2);
        y = new BigInteger(ns);
        System.out.println("Compliant BigInteger: " + y);
    }
}
