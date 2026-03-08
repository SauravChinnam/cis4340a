import java.io.FileInputStream;
import java.io.IOException;


public class R08_ERR00_J {


    public static void readFile() {
        try {
            FileInputStream fis = new FileInputStream("somefile.txt");
            int data = fis.read();
            while (data != -1) {

                data = fis.read();
            }
            fis.close();
        } catch (IOException e) {

        }
    }


    public static void readFileCompliant() {
        try {
            FileInputStream fis = new FileInputStream("somefile.txt");
            int data = fis.read();
            while (data != -1) {

                data = fis.read();
            }
            fis.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());

        }
    }

    public static void main(String[] args) {

        readFileCompliant();
    }
}
