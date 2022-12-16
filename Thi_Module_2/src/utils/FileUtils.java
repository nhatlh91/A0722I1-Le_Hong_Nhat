package utils;

import model.Account;
import model.PayingAccount;
import model.SavingAccount;

import java.io.*;
import java.util.ArrayList;

public class FileUtils {
    private static final String FILE_PATH = "D:\\CODEGYM\\Git\\Thi_Module_2\\src\\data\\bank_account.csv";

    public static void writeToFile(ArrayList<Account> accounts) {
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            if (accounts.isEmpty()) {
                return;
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Account account : accounts) {
                bufferedWriter.write(account.toFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Account> readFromFile() {
        ArrayList<Account> accounts = new ArrayList<>();
        try {
            File file = new File(FILE_PATH);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] props = line.split(",");
                if (props.length == 8) {
                    accounts.add(new SavingAccount(Integer.parseInt(props[0]),props[1],props[2],
                        DateUtils.parseLocalDate(props[3]),Double.parseDouble(props[4]),
                            DateUtils.parseLocalDate(props[5]),Double.parseDouble(props[6]),Integer.parseInt(props[7])));
                } else {
                    accounts.add(new PayingAccount(Integer.parseInt(props[0]),props[1],props[2],
                            DateUtils.parseLocalDate(props[3]),props[4],Double.parseDouble(props[5])));
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return accounts;
    }
}
