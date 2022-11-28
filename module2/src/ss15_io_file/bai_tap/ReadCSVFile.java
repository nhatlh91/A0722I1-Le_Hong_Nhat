package ss15_io_file.bai_tap;

import java.io.*;
import java.util.LinkedList;

public class ReadCSVFile {
    private static final String SOURCE ="D:\\CODEGYM\\Git\\module2\\src\\ss15_io_file\\bai_tap\\data.csv";
    public static LinkedList<Country> readFile(String filePath){
        LinkedList<Country> content = new LinkedList<>();
        try {
            File file = new File(filePath);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while ((line = br.readLine()) != null) {
                String[] props = line.split(",");
                content.add(new Country(Integer.parseInt(props[0]),props[1].replaceAll("\"",""),props[2].replaceAll("\"","")));
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static void main(String[] args) {
        LinkedList<Country> dataList = readFile(SOURCE);
        for (Country country : dataList) {
            System.out.println(country.toString());
        }
    }
}
