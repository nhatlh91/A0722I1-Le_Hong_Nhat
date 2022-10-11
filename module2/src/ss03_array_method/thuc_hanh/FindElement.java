package ss03_array_method.thuc_hanh;
import java.util.Locale;
import java.util.Scanner;
public class FindElement {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name of student: ");
        String input_name = scanner.nextLine().toLowerCase();
        boolean isExist = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].toLowerCase().equals(input_name)) {
                System.out.println("Position of the students in the list " + students[i] + " is: " + (i + 1));
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            System.out.println("Not found " + input_name + " in the list.");
        }
    }
}
