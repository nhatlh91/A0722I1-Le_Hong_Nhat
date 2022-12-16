package utils;

import libs.AgeValidateException;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class DateUtils implements Pattern{
    private static Scanner sc = new Scanner(System.in);

    public static boolean ageValidate(LocalDate birthday) {
        int age = Period.between(birthday, LocalDate.now()).getYears();
        return (age >= 18 && age <= 100);
    }

    public static LocalDate inputBirthday() {
        LocalDate birthday = null;
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("Input birthday:");
                String input = sc.nextLine();
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                birthday = LocalDate.parse(input, dateFormat);
                if (!ageValidate(birthday)) {
                    throw new AgeValidateException();
                }
                flag = false;
            } catch (DateTimeParseException e) {
                System.err.println("Wrong pattern, please re-do:");
                flag = true;
            } catch (AgeValidateException ex) {
                ex.message();
                flag = true;
            }
        }
        return birthday;
    }
    public static LocalDate inputDate() {
        LocalDate date = null;
        boolean flag = true;
        while (flag) {
            try {
                String input = sc.nextLine();
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                date = LocalDate.parse(input, dateFormat);
                flag = false;
            } catch (DateTimeParseException e) {
                System.err.println(WRONG_INPUT);
                flag = true;
            }
        }
        return date;
    }

        public static LocalDate parseLocalDate(String input){
            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(input, dateFormat);
        }
}
