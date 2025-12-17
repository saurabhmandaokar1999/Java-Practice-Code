public class ProducerConsumer {

    // Shared resource (monitor object)
    static class SharedBuffer {
        private int data;
        private boolean hasData = false;

        // Producer method
        public synchronized void produce(int value) throws InterruptedException {
            while (hasData) {
                wait(); // releases monitor, thread enters WAITING
            }

            data = value;
            hasData = true;
            System.out.println(Thread.currentThread().getName()
                    + " produced: " + value);

            notify(); // wakes one waiting thread (does NOT release lock)
        }

        // Consumer method
        public synchronized int consume() throws InterruptedException {
            while (!hasData) {
                wait(); // releases monitor, thread enters WAITING
            }

            int value = data;
            hasData = false;
            System.out.println(Thread.currentThread().getName()
                    + " consumed: " + value);

            notify(); // wakes producer
            return value;
        }
    }

    public static void main(String[] args) {

        SharedBuffer buffer = new SharedBuffer();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.produce(i);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Producer");

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    buffer.consume();
                    Thread.sleep(800);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }, "Consumer");

        producer.start();
        consumer.start();
    }
}