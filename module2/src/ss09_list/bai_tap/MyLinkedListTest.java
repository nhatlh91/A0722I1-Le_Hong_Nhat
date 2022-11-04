package ss09_list.bai_tap;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> listB = new MyLinkedList();
        listB.addFirst(1);
        listB.addFirst(2);
        listB.addFirst(3);
        listB.addFirst(4);
        listB.addFirst(5);
        listB.addFirst(6);
        listB.printList();
        listB.addLast(8);
        listB.addLast(9);
        listB.addLast(10);
        listB.printList();
        listB.remove(2);
        listB.printList();
        listB.remove(4);
        listB.printList();
        listB.remove(4);
        listB.printList();
        listB.add(5, 12);
        listB.printList();
        listB.add(2, 15);
        listB.printList();
        listB.add(2, 13);
        listB.printList();
        listB.remove(new Integer(13));
        listB.printList();
        MyLinkedList<Integer> listC = (MyLinkedList<Integer>) listB.clone();
        listC.printList();
        System.out.println(listC.contains(3));
        System.out.println(listC.contains(12));
        System.out.println(listC.contains(54));
        System.out.println(listC.contains(1));
        System.out.println(listC.indexOf(75));
        System.out.println(listC.indexOf(13));
        System.out.println(listC.indexOf(10));
        System.out.println(listC.indexOf(6));
        System.out.print(listC.get(1) + "\t");
        System.out.print(listC.get(2) + "\t");
        System.out.print(listC.get(4) + "\t");
        System.out.print(listC.get(7) + "\t");

    }
}
