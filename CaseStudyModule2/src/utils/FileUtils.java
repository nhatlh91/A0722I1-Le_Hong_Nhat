package utils;

import java.io.*;
import java.util.ArrayList;

public class FileUtils {
    public static void writetoFile(String path, ArrayList<String> content) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            if (content.isEmpty()){
                return;
            }
            FileWriter writer = new FileWriter(path, false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (int i = 0; i<content.size(); i++) {
                bufferedWriter.write(content.get(i));
                bufferedWriter.newLine();
            }
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
}
