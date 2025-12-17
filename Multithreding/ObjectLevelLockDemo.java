public class ObjectLevelLockDemo {

    // Shared object whose monitor lock will be used
    static class Counter {
        private int count = 0;

        // Object-level lock (lock is on "this" Counter instance)
        public void increment() {
            synchronized (this) {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " acquired lock");

                count++; 
                try {
                    // Sleep to clearly show locking behavior
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

                System.out.println(threadName + " released lock, count = " + count);
            }
        }
    }

    public static void main(String[] args) {

        Counter counter = new Counter(); // ONE object

        Thread t1 = new Thread(counter::increment, "Thread-1");
        Thread t2 = new Thread(counter::increment, "Thread-2");

        t1.start();
        t2.start();
    }
}

