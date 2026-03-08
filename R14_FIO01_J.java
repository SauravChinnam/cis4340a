import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileAttribute;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;


public class R14_FIO01_J {


    public static void writeFile() throws IOException {
        File file = new File("example.txt");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write("Sensitive data".getBytes());
        }
    }


    public static void writeFileCompliant() throws IOException {
        Path path = Paths.get("example.txt");

        Files.deleteIfExists(path);
        Set<PosixFilePermission> perms = PosixFilePermissions.fromString("rw-------");
        FileAttribute<Set<PosixFilePermission>> attr = PosixFilePermissions.asFileAttribute(perms);
        try {
            Files.createFile(path, attr);
        } catch (FileAlreadyExistsException e) {

        }
        Files.write(path, "Sensitive data".getBytes());
    }

    public static void main(String[] args) throws IOException {
        writeFile();
        writeFileCompliant();
    }
}
