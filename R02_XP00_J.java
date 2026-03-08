import java.io.File;


public class R02_XP00_J {


    public void deleteFile() {
        File someFile = new File("someFileName.txt");

        someFile.delete();
    }


    public void deleteFileCompliant() {
        File someFile = new File("someFileName.txt");

        if (!someFile.delete()) {

            System.err.println("Failed to delete file: " + someFile.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        R02_XP00_J demo = new R02_XP00_J();
        demo.deleteFile();

    }
}
