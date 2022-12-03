package utils;

import models.*;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class FileUtils {
    private static final String EMPLOYEE_FILE = "/mnt/01D8F8C16EEA6020/CODEGYM/Git/CaseStudyModule2/src/data/employee.csv";
    private static final String CUSTOMER_FILE = "/mnt/01D8F8C16EEA6020/CODEGYM/Git/CaseStudyModule2/src/data/customer.csv";
    private static final String VILLA_FILE = "/mnt/01D8F8C16EEA6020/CODEGYM/Git/CaseStudyModule2/src/data/villa.csv";
    private static final String HOUSE_FILE = "/mnt/01D8F8C16EEA6020/CODEGYM/Git/CaseStudyModule2/src/data/house.csv";
    private static final String ROOM_FILE = "/mnt/01D8F8C16EEA6020/CODEGYM/Git/CaseStudyModule2/src/data/room.csv";
    private static final String COMMA = ",";

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

    public static ArrayList<Employee> readEmployeeFile(){
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

    public static void writeEmployeeFile(ArrayList<Employee> employees){
        try {
            File file = new File(EMPLOYEE_FILE);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            if (employees.isEmpty()) {
                return;
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Employee employee : employees) {
                bufferedWriter.write(employee.toFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedList<Customer> readCustomerFile() {
        LinkedList<Customer> customers = new LinkedList<>();
        try {
            File file = new File(CUSTOMER_FILE);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] props = line.split(",");
                customers.add(new Customer(props[0], props[1], DateUtils.parseLocalDate(props[2]),  props[3], props[4], props[5], props[6], props[7], props[8]));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    public static void writeCustomerFile(LinkedList<Customer> customers){
        try {
            File file = new File(CUSTOMER_FILE);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            if (customers.isEmpty()) {
                return;
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Customer customer : customers) {
                bufferedWriter.write(customer.toFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedHashMap<Villa,Integer> readVillaFile() {
        LinkedHashMap<Villa,Integer> villas = new LinkedHashMap<>();
        try {
            File file = new File(VILLA_FILE);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] props = line.split(",");
                villas.put(new Villa(props[0], Double.parseDouble(props[1]), Double.parseDouble(props[2]), Integer.parseInt(props[3]), props[4], props[5], Double.parseDouble(props[6]), Integer.parseInt(props[7])), Integer.parseInt(props[8]));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return villas;
    }

    public static void writeVillaFile(LinkedHashMap<Villa,Integer> villas){
        try {
            File file = new File(VILLA_FILE);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            if (villas.isEmpty()) {
                return;
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            String temp;
            for (Villa villa : villas.keySet()) {
                temp = villa.toFile()+COMMA+villas.get(villa);
                bufferedWriter.write(temp);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedHashMap<House,Integer> readHouseFile() {
        LinkedHashMap<House,Integer> houses = new LinkedHashMap<>();
        try {
            File file = new File(HOUSE_FILE);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] props = line.split(",");
                houses.put(new House(props[0], Double.parseDouble(props[1]), Double.parseDouble(props[2]), Integer.parseInt(props[3]), props[4], props[5], Integer.parseInt(props[6])), Integer.parseInt(props[7]));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return houses;
    }

    public static void writeHouseFile(LinkedHashMap<House,Integer> houses){
        try {
            File file = new File(HOUSE_FILE);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            if (houses.isEmpty()) {
                return;
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            String temp;
            for (House house : houses.keySet()) {
                temp = house.toFile()+COMMA+houses.get(house);
                bufferedWriter.write(temp);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static LinkedHashMap<Room,Integer> readRoomFile() {
        LinkedHashMap<Room,Integer> rooms = new LinkedHashMap<>();
        try {
            File file = new File(ROOM_FILE);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] props = line.split(",");
                rooms.put(new Room(props[0], Double.parseDouble(props[1]), Double.parseDouble(props[2]), Integer.parseInt(props[3]), props[4], props[5]), Integer.parseInt(props[6]));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rooms;
    }

    public static void writeRoomFile(LinkedHashMap<Room,Integer> rooms){
        try {
            File file = new File(ROOM_FILE);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            if (rooms.isEmpty()) {
                return;
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            String temp;
            for (Room room : rooms.keySet()) {
                temp = room.toFile()+COMMA+rooms.get(room);
                bufferedWriter.write(temp);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
