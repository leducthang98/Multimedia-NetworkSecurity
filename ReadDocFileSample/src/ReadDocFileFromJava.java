
import org.apache.poi.poifs.filesystem.*;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hwpf.*;
import org.apache.poi.hwpf.extractor.*;
import org.apache.poi.hwpf.usermodel.HeaderStories;

import java.io.*;

public class ReadDocFileFromJava {

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\Wind\\Pictures\\ANM\\sdas.txt";
        String data = readData(fileName);
        System.out.println(data);
        
    }

    public static String readData(String fileName) throws FileNotFoundException, IOException {
        String result = "";
        String typeOfFile = fileName.substring(fileName.length() - 4);
        if (typeOfFile.equals(".doc")) {
            POIFSFileSystem fs = null;
            try {
                fs = new POIFSFileSystem(new FileInputStream(fileName));
                HWPFDocument doc = new HWPFDocument(fs);
                WordExtractor we = new WordExtractor(doc);
                String[] paragraphs = we.getParagraphText();
                for (int i = 0; i < paragraphs.length; i++) {

                    result += paragraphs[i].toString();

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (typeOfFile.equals(".txt")) {
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            result += line + "\r\n";
            while (line != null) {
                line = reader.readLine();
                result += line + "\r\n";
            }

            reader.close();
        }

        return result;
    }

}
