package ss09_list.bai_tap;

public class Node {
    public Node next;
    private Object data;

    Node(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
