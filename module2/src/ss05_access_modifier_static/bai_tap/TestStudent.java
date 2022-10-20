package ss05_access_modifier_static.bai_tap;

public class TestStudent {
    public static void main(String[] args) {
        Student studentA = new Student();
        System.out.println(studentA);
        studentA.setName("Brian");
        studentA.setClasses("A07");
        System.out.println(studentA);
    }
}
