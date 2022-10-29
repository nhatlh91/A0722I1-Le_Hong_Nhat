package ss09_list.bai_tap;

public class MyList<E> {
    private int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    Object elements[];

    MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    };

    MyList(int capacity) {
        elements = new Object[capacity];
    }

    public void add(int index, E element) {
        if (elements[index] != null) {
            elements[index] = element;
            size++;
        } else System.out.println("There is not an empty index");
    }

    public E remove(int index) throws Exception {
        if (elements[index] != null) {
          E tempElement = (E) elements[index];
          elements[index] = null;
            size--;
            return tempElement;
        } else throw new Exception("Index sai roi thang ngu");
    }

    public int getSize(){
        return size;
    }

    public E clone() {
       Object tempElements = elements;
    }


}
