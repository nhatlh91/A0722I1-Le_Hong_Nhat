package services.impl;

import utils.DateUtils;
import utils.Pattern;

import java.time.LocalDate;
import java.util.Scanner;

public class TestingClass implements Pattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        String string = "Male";
//        System.out.println(string.matches(GENDER_PATTERN));
//        String string2 = "42 Hoa Nam 07 - Hoa Khanh Bac - Lien Chieu - TP.Da Nang";
//        System.out.println(string2.matches(ADDRESS_PATTERN));
//        String string3 = "Staff00";
//        System.out.println(string3.matches(STAFF_ID_PATTERN));
//        String string4 = "Nam Em";
//        System.out.println(string4.matches(NAME_PATTERN));
//        String string5 = "745734739";
//        System.out.println(string5.matches(ID_PATTERN));
//        String string6 = "nhatlh@yahoo.com";
//        System.out.println(string6.matches(EMAIL_PATTERN));
//        String phone = "0905598909";
//        System.out.println(phone.matches(PHONE_PATTERN));
//        String phone2 = "+84905598909";
//        System.out.println(phone2.matches(PHONE_PATTERN));
//        String phone3 = "09055968909";
//        System.out.println(phone3.matches(PHONE_PATTERN));
//        String phone4 = "+849055898909";
//        System.out.println(phone4.matches(PHONE_PATTERN));
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        facilityService.displayFacilityMenu();
    }
}