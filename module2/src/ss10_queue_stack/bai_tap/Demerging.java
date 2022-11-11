package ss10_queue_stack.bai_tap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Demerging {
    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<>();
        Queue<Person> maleQueue = new LinkedList<>();
        Queue<Person> femaleQueue = new LinkedList<>();
        list.add(new Person("Nhan", "Male", "2005"));
        list.add(new Person("Duc", "Male", "2004"));
        list.add(new Person("Van", "Female", "2003"));
        list.add(new Person("Thao", "Female", "2002"));
        list.add(new Person("Nhat", "Male", "2001"));
        list.add(new Person("Trinh", "Female", "2000"));
        list.add(new Person("Khanh", "Male", "1999"));
        System.out.println("Danh sach truoc khi sap xep:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        for (int i = 0; i < list.size(); i++) {
            Person temp = list.get(i);
            if (temp.getGender().equals("Female")) {
                femaleQueue.add(temp);
            } else {
                maleQueue.add(temp);
            }
        }
        list.clear();
        while (!maleQueue.isEmpty()) {
            list.add(maleQueue.remove());
        }
        while (!femaleQueue.isEmpty()) {
            list.add(femaleQueue.remove());
        }
        System.out.println("Danh sach sau khi sap xep:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}