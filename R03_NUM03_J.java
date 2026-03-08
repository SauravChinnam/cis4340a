import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;


public class R03_NUM03_J {


    public static int getInteger(DataInputStream is) throws IOException {
        return is.readInt();
    }


    public static long getIntegerCompliant(DataInputStream is) throws IOException {
        return is.readInt() & 0xFFFFFFFFL;
    }

    public static void main(String[] args) throws Exception {

        byte[] data = { (byte)0xFF, (byte)0xFF, (byte)0xFF, (byte)0xFF };
        DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));


        long value = getIntegerCompliant(dis);
        System.out.println("Compliant value: " + value);
    }
}
