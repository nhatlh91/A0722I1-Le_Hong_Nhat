package com.example.case_study.utils;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class DateUtil implements Pattern{
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
                flag = false;
            } catch (DateTimeParseException e) {
                System.err.println("Wrong pattern, please re-do:");
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

    public static Date parseDate(String input){
        Date date = null;
//        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(input);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String parseString(Date date) {
        String result = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        result = formatter.format(date);
        return result;
    }
}
