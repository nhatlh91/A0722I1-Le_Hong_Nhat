package ss15_io_file.bai_tap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class ReadCSVFile {
    private static final String SOURCE = "D:\\CODEGYM\\Git\\module2\\src\\ss15_io_file\\bai_tap\\data.csv";
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

    public static void main(String[] args) {
        ArrayList<String> dataList = readFile(SOURCE);
        for (String item : dataList) {
            String[] temp = item.split(",");
            for (String string: temp){
                System.out.print(string + "\t");
            }
            System.out.println();
        }
    }
}
