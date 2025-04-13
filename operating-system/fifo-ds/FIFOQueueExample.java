
public class FIFOQueueExample {
    public static void main(String[] args) {
        FIFOQueue<Integer> queue = new FIFOQueue<>();

        // Enqueue elements
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        // Dequeue elements
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());

        // Check if queue is empty
        System.out.println("Is queue empty? " + queue.isEmpty());

        // Enqueue more elements
        queue.enqueue(40);
        queue.enqueue(50);

        // Dequeue remaining elements
        while (!queue.isEmpty()) {
            System.out.println("Dequeued: " + queue.dequeue());
        }

        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class FIFOQueue<T> {
    private Node<T> front, rear;
    private int size;

    public FIFOQueue() {
        this.front = this.rear = null;
        this.size = 0;
    }

    // Enqueue (add an item to the queue)
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Dequeue (remove an item from the queue)
    public T dequeue() {
        if (front == null) {
            System.out.println("Queue is empty");
            return null;
        }
        T data = front.data;
        front = front.next;
        if (front == null) { // If queue becomes empty
            rear = null;
        }
        size--;
        return data;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Get the size of the queue
    public int getSize() {
        return size;
    }
}

