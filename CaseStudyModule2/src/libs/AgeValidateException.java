package libs;

import utils.DateUtils;

import java.time.LocalDate;
import java.util.Scanner;

public class AgeValidateException extends Exception {
    public void message(){
        System.err.println("The customer age is not meet our requirement!!");
    }
}
