
public class R06_MET01_J {


    public static int getAbsAdd(int x, int y) {
        assert x != Integer.MIN_VALUE;
        assert y != Integer.MIN_VALUE;
        int absX = Math.abs(x);
        int absY = Math.abs(y);
        assert (absX <= Integer.MAX_VALUE - absY);
        return absX + absY;
    }


    public static int getAbsAddCompliant(int x, int y) {
        if (x == Integer.MIN_VALUE || y == Integer.MIN_VALUE) {
            throw new IllegalArgumentException();
        }
        int absX = Math.abs(x);
        int absY = Math.abs(y);
        if (absX > Integer.MAX_VALUE - absY) {
            throw new IllegalArgumentException();
        }
        return absX + absY;
    }

    public static void main(String[] args) {

        try {
            int result = getAbsAdd(Integer.MIN_VALUE, 1);
            System.out.println("Noncompliant result: " + result);
        } catch (AssertionError e) {
            System.err.println("Assertion failed: " + e.getMessage());
        }


        try {
            int result2 = getAbsAddCompliant(Integer.MIN_VALUE, 1);
            System.out.println("Compliant result: " + result2);
        } catch (IllegalArgumentException e) {
            System.err.println("Illegal argument: " + e.getMessage());
        }
    }
}
