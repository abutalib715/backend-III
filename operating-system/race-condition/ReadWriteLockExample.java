import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
    public static void main(String[] args) {
        RWSharedResource resource = new RWSharedResource();

        // Multiple reader threads
        Runnable readTask = () -> resource.readData(Thread.currentThread().getName());

        // Single writer thread
        Runnable writeTask = () -> resource.writeData(Thread.currentThread().getName(), 42);

        Thread writer1 = new Thread(writeTask, "Writer-1");
        Thread writer2 = new Thread(writeTask, "Writer-2");
        Thread reader1 = new Thread(readTask, "Reader-1");
        Thread reader2 = new Thread(readTask, "Reader-2");
        Thread reader3 = new Thread(readTask, "Reader-3");
        Thread reader4 = new Thread(readTask, "Reader-4");

        reader1.start();
        reader2.start();
        writer1.start();
        writer2.start();
        reader3.start();
        reader4.start();
    }
}

class RWSharedResource {
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    private int data = 0;

    // Read operation (multiple readers allowed)
    public void readData(String threadName) {
        rwLock.readLock().lock();
        try {
            System.out.println(threadName + " is reading data: " + data);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwLock.readLock().unlock();
        }
    }

    // Write operation (only one writer allowed)
    public void writeData(String threadName, int value) {
        rwLock.writeLock().lock();
        try {
            System.out.println(threadName + " is writing data: " + value);
            Thread.sleep(2000);
            data = value;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rwLock.writeLock().unlock();
        }
    }
}