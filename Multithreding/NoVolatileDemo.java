public class NoVolatileDemo {

    // NOT volatile
    private static volatile boolean running = true;

    public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(() -> {
            System.out.println("Worker started...");
            while (running) {
                // busy wait
            }
            System.out.println("Worker stopped.");
        });

        worker.start();

        Thread.sleep(2000); // let worker run
        System.out.println("Main thread stopping worker...");
        running = false;
    }
}
