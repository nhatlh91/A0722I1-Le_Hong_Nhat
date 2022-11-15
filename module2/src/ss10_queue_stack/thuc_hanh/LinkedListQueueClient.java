package ss10_queue_stack.thuc_hanh;

public class LinkedListQueueClient {
    public static void main(String[] args) {
        MyLinkedListQueue queueA = new MyLinkedListQueue();
        queueA.enqueue(10);
        queueA.enqueue(20);
        queueA.dequeue();
        queueA.dequeue();
        queueA.enqueue(30);
        queueA.enqueue(40);
        queueA.enqueue(50);
        System.out.println("Dequeued item is " + queueA.dequeue().key);
    }
}
