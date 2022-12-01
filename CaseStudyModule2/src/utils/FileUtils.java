package utils;

import models.Employee;

import java.io.*;
import java.util.ArrayList;

public class FileUtils {
    private static final String EMPLOYEE_FILE = "/mnt/01D8F8C16EEA6020/CODEGYM/Git/CaseStudyModule2/src/data/employee.csv";
    private static final String CUSTOMER_FILE = "D:\\CODEGYM\\Git\\CaseStudyModule2\\src\\data\\customer.csv";
    private static final String VILLA_FILE = "D:\\CODEGYM\\Git\\CaseStudyModule2\\src\\data\\customer.csv";
    private static final String HOUSE_FILE = "D:\\CODEGYM\\Git\\CaseStudyModule2\\src\\data\\customer.csv";
    private static final String ROOM_FILE = "D:\\CODEGYM\\Git\\CaseStudyModule2\\src\\data\\customer.csv";


    public static void overwriteToFile(String path, ArrayList<String> content) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            if (content.isEmpty()) {
                return;
            }
            FileWriter writer = new FileWriter(path, false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (int i = 0; i < content.size(); i++) {
                bufferedWriter.write(content.get(i));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addToFile(String path, String content) {
        if (content == null || content.equals("")) {
            return;
        }
        try {
            File file = new File(path);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
            bufferedWriter.write(content);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> readFromFile(String path) {
        ArrayList<String> list = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Employee> readEmployeeListFromFile(){
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            File file = new File(EMPLOYEE_FILE);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] props = line.split(",");
                employees.add(new Employee(props[0],props[1],DateUtils.parseLocalDate(props[2]),props[3],props[4],
                        props[5],props[6],props[7],props[8],Integer.parseInt(props[9])));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public static void writeEmployeeListToFile(ArrayList<Employee> employees){
        try {
            File file = new File(EMPLOYEE_FILE);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            if (employees.isEmpty()) {
                return;
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(EMPLOYEE_FILE));
            for (int i = 0; i < employees.size(); i++) {
                bufferedWriter.write(employees.get(i).toFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
