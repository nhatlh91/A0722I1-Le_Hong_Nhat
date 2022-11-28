package libs;

public class AgeValidateException extends Exception{
    public void noti(){
        System.err.println("The age of customer is not meet the requirement. Re input.");
    }
}
