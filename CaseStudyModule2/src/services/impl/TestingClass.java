package services.impl;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static services.impl.EmployeeServiceImpl.dateInput;

public class TestingClass {
    public static void main(String[] args) {
        CustomerServiceImpl testingObj = new CustomerServiceImpl();
        testingObj.add();

//        LocalDate birthday = dateInput("19/11/2005");
//        System.out.println(CustomerServiceImpl.ageValidator(birthday));
    }
}
