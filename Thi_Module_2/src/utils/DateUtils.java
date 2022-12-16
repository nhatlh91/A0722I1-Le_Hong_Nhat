package utils;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

    public class DateUtils implements Pattern{
        private static Scanner sc = new Scanner(System.in);
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
