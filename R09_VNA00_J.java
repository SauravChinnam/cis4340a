
public class R09_VNA00_J {

    private static boolean stop = false;


    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            while (!stop) {

            }
            System.out.println("Noncompliant worker stopped");
        });
        worker.start();
        Thread.sleep(1000);
        stop = true;
        worker.join();


        runCompliantExample();
    }


    private static volatile boolean stopCompliant = false;

    private static void runCompliantExample() throws InterruptedException {
        Thread worker = new Thread(() -> {
            while (!stopCompliant) {

            }
            System.out.println("Compliant worker stopped");
        });
        worker.start();
        Thread.sleep(1000);
        stopCompliant = true;
        worker.join();
    }
}
