package ss09_list.bai_tap;

public class MyLinkedList<E> {
    public Node head;
    public int numNodes;

    MyLinkedList() {
    }

    public void add(int index, E element) {
        Node newNode = new Node(element);
        Node temp;
        temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        numNodes++;
    }

    public void addFirst(E element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    public void addLast(E element) {
        Node lastNode, temp;
        lastNode = new Node(element);
        temp = head;
        if (temp == null) {
            addFirst(element);
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = lastNode;
        }
        numNodes++;
    }

    public void remove(int index) {
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        numNodes--;
    }

    public boolean remove(Object element) {
        Node temp = head;
        Node tempB = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.equals(element)) {
                for (int j = 0; j < i; j++) {
                    tempB = tempB.next;
                }
                tempB.next = tempB.next.next;
                numNodes--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public boolean contains(E element) {
        Node temp = this.head;
        while (temp.next != null) {
            if (temp.getData().equals(element)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E element) {
        int count = 0;
        Node temp = this.head;
        while (temp != null) {
            if (temp.getData().equals(element)) {
                return count;
            }
            temp = temp.next;
            count++;
        }
        return -1;
    }


    public int size() {
        return numNodes;
    }

    public MyLinkedList clone() {
        Node tempNode = head;
        MyLinkedList newList = new MyLinkedList();
        while (tempNode != null) {
            newList.addLast(tempNode.getData());
            tempNode = tempNode.next;
        }
        return newList;
    }

    public void printList() {
        if (head != null) {
            System.out.print("List is: ");
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.getData() + "\t");
                temp = temp.next;
            }
            System.out.println();
        } else System.out.println("List is empty!!");
    }

    public E get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return (E) temp.getData();
    }
}
