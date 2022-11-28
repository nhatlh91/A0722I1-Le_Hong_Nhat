package utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    public static boolean ageValidate(LocalDate birthday){
        int age = Period.between(birthday, LocalDate.now()).getYears();
        return (age >= 18 && age <= 100);
    }

    public static LocalDate dateInput(String userInput) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(userInput, dateFormat);
    }
}
