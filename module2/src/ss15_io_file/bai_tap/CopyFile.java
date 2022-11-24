package ss15_io_file.bai_tap;

import java.io.*;
import java.util.ArrayList;

public class CopyFile {
    public static ArrayList<String> readFile(String filePath){
        ArrayList<String> content = new ArrayList<>();
        try {
            File file = new File(filePath);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                content.add(line);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("Fie không tồn tại or nội dung có lỗi!");
        }
        return content;
    }


    public static int writeFile(String filePath, ArrayList<String> content){
        int count = 0;
        try {
            FileWriter writer = new FileWriter(filePath, false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (String item:content) {
                bufferedWriter.write(item);
                bufferedWriter.newLine();
                count += item.length();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static void main(String[] args) {
        final String SOURCE = "D:\\CODEGYM\\Git\\module2\\src\\ss15_io_file\\bai_tap\\source.txt";
        final String TARGET = "D:\\CODEGYM\\Git\\module2\\src\\ss15_io_file\\bai_tap\\target.txt";
        ArrayList<String> content = readFile(SOURCE);
        System.out.println("The file has been copied and has " + writeFile(TARGET,content) + " letters");
    }
}
