import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedListExample {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println(queue.poll());  // Removes and returns 10
        System.out.println(queue.peek());  // Returns 20 but does not remove
    }
}
