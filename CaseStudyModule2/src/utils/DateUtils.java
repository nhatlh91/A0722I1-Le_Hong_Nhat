package utils;

import libs.AgeValidateException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateUtils {
    private static Scanner sc = new Scanner(System.in);

    public static boolean ageValidate(LocalDate birthday) {
        int age = Period.between(birthday, LocalDate.now()).getYears();
        return (age >= 18 && age <= 100);
    }

    public static LocalDate parseLocalDate(String input) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate birthday = null;
        while (birthday == null) {
            try {
                birthday = LocalDate.parse(input, dateFormat);
                if (!ageValidate(birthday)) {
                    throw new AgeValidateException();
                }
                return birthday;
            } catch (AgeValidateException e) {
                e.message();
            } catch (DateTimeParseException e) {
                e.getStackTrace();
            }
        }
        return birthday;
    }

        public static LocalDate inputBirthday() {
           while (true) {
                    System.out.println("Enter birthday:");
                    return parseLocalDate(sc.nextLine());
                }
            }
}
