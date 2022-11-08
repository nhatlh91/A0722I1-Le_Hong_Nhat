package ss10_queue_stack.bai_tap;

public class Solution extends Queue {
    Solution(){
        super();
    }
    public void enQueue(Node newNode) {
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.link = front;
            rear.link = newNode;
            rear = newNode;
        }
    }

    public Node deQueue() {
        if (isEmpty()) {
            return null;
        } else {
            Node tempNode = front;
            front = front.link;
            rear.link = front;
            return tempNode;
        }
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            Node tempNode = front;
            do {
                System.out.println(tempNode.data + "\t");
                tempNode = tempNode.link;
            }
            while (tempNode != front);
        }
    }

    public boolean isEmpty() {
        return front == null && rear == null;
    }

    public static void main(String[] args) {
        Solution myQueue = new Solution();
        Node newNode = new Node(1);
        myQueue.enQueue(newNode);
        Node newNode2 = new Node(2);
        myQueue.enQueue(newNode2);
        Node newNode3 = new Node(3);
        myQueue.enQueue(newNode3);
        Node newNode4 = new Node(4);
        myQueue.enQueue(newNode4);
        myQueue.displayQueue();
        System.out.println("Dequeued item: "+myQueue.deQueue());
        myQueue.displayQueue();
    }
}
