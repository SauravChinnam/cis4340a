import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class R15_SER03_J {

    static class CredentialsNonCompliant implements Serializable {
        private String username;
        private String password;

        CredentialsNonCompliant(String user, String pass) {
            this.username = user;
            this.password = pass;
        }
    }

    static class CredentialsCompliant implements Serializable {
        private String username;
        private transient String password;

        CredentialsCompliant(String user, String pass) {
            this.username = user;
            this.password = pass;
        }
    }

    public static void main(String[] args) {

        CredentialsNonCompliant creds = new CredentialsNonCompliant("user", "secret");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("creds_noncompliant.ser"))) {
            oos.writeObject(creds);
        } catch (IOException e) {
            System.err.println("Error serializing noncompliant credentials: " + e.getMessage());
        }


        CredentialsCompliant safeCreds = new CredentialsCompliant("user", "secret");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("creds_compliant.ser"))) {
            oos.writeObject(safeCreds);
        } catch (IOException e) {
            System.err.println("Error serializing compliant credentials: " + e.getMessage());
        }
    }
}
