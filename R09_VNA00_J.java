
public class R09_VNA00_J {



    public static void main(String[] args) throws InterruptedException {

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
