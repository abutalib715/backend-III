import java.util.concurrent.locks.ReentrantLock;

public class MutexExample {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        Runnable task = () -> sharedResource.accessResource(Thread.currentThread().getName());

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        t1.start();
        t2.start();
    }
}


class SharedResource {
    private final ReentrantLock lock = new ReentrantLock();

    public synchronized void accessResource(String threadName) {
        lock.lock();  // Acquiring the lock
        try {
            System.out.println(threadName + " is accessing the resource...");
            Thread.sleep(1000); // Simulating work
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock(); // Releasing the lock
            System.out.println(threadName + " has released the lock.");
        }
    }
}