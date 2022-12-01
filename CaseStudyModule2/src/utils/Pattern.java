package utils;

public interface Pattern {
    String NAME_PATTERN = "[a-zA-Z ]*";
    String GENDER_PATTERN = "Male|Female";
    String ID_PATTERN = "\\d{9}|\\d{12}";
    String PHONE_PATTERN = "^0\\d{9,10}|^\\+84\\d{9,10}";
    String EMAIL_PATTERN = "[a-z0-9_.]+@[a-z]+.[a-z]+";
    String STAFF_ID_PATTERN = "Staff\\d+";
    String ACADEMIC_LEVEL_PATTERN = "College|University|Master|Post-Graduate";
    String POSITION_PATTERN = "Staff|Head|Vice-Director|Director|President";
    String ADDRESS_PATTERN = "[0-9A-Za-z -.]+";
    String SALARY_PATTERN = "\\d+";
}
