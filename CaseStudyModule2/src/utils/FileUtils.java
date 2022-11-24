package utils;

import java.io.*;
import java.util.ArrayList;

public class FileUtils {
    public static void writetoFile(String path, String content) {
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            FileWriter writer = new FileWriter(path, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(content);
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> readFromFile(String path) {
        ArrayList<String> dataFromFile = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FileNotFoundException();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                dataFromFile.add(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataFromFile;
    }
}
