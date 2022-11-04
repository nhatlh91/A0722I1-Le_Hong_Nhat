package ss09_list.bai_tap;

public class MyListTest {
    public static void main(String[] args) throws Exception {
        MyList listA = new MyList();
        listA.printout();
        System.out.println();
        listA.add(1);
        listA.add(2);
        listA.add(3);
        listA.add(4);
        listA.add(5);
        listA.add(6);
        listA.add(7);
        listA.add(8);
        listA.add(9);
        listA.add(10);
        listA.add(11);
        listA.add(12);
        listA.add(13);
        listA.printout();
        System.out.println();
        listA.add(4, 14);
        listA.add(4, 15);
        System.out.println("Element at index 11: " + listA.get(11));
        listA.printout();
        System.out.println();
        listA.remove(7);
        listA.remove(9);
        listA.printout();
        System.out.println();
        System.out.println("Index of 15: " + listA.indexOf(15));
        System.out.println("Index of 6: " + listA.indexOf(6));
        listA.clear();
        listA.printout();

    }
}
