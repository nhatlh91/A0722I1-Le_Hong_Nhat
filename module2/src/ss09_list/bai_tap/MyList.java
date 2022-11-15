package ss09_list.bai_tap;

public class MyList<E> {
    static final int DEFAULT_CAPACITY = 10;
    Object elements[];
    private int size = 0;

    MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    ;

    MyList(int capacity) {
        elements = new Object[capacity];
    }

    public void add(E element) {
        ensureCapa();
        for (int i = 0; i <= this.size; i++) {
            if (elements[i] == null) {
                elements[i] = element;
                this.size++;
                break;
            }
        }
    }

    public void add(int index, E element) {
        ensureCapa();
        if (elements[index] != null) {
            for (int i = size; i > index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        } else System.out.println("There is not an empty index");
    }

    public E remove(int index) throws Exception {
        if (elements[index] != null) {
            E tempElement = (E) elements[index];
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            elements[size - 1] = null;
            size--;
            return tempElement;
        } else throw new Exception("Index sai dồi bạn ôi, ối dồi ôi");
    }

    public int size() {
        return size;
    }

    public void ensureCapa() {
        if (elements.length == this.size()) {
            Object[] tempElements = new Object[elements.length * 2];
            for (int i = 0; i < size; i++) {
                tempElements[i] = elements[i];
            }
            elements = tempElements;
        }
    }

    public Object clone() {
        Object[] tempElements = new Object[elements.length];
        for (int i = 0; i < size; i++) {
            tempElements[i] = elements[i];
        }
        return tempElements;
    }

    public boolean contains(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(E element) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public E get(int index) throws Exception {
        if (elements[index] != null) {
            return (E) elements[index];
        } else throw new Exception("Index null dồi bạn ôi, ối dồi ôi");
    }

    public void clear() {
        while (this.size != 0) {
            elements[size - 1] = null;
            this.size--;
        }
    }

    public void printout() {
        if (size != 0) {
            System.out.print("The list is: ");
            for (int i = 0; i < size; i++) {
                System.out.print(elements[i] + "\t");
            }
        } else System.out.println("The list is empty");
    }
}
