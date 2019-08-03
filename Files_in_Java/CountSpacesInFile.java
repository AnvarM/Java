package Files_in_Java;

//посчитать отношение количества пробелов ко общему количеству символов в файле и округлить до 2-х знаков после запятой

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class CountSpacesInFile {
    public static void main(String[] args) throws IOException {
        DecimalFormat df = new DecimalFormat("0.00"); //  pattern for round

        String fileName = args[0];
        FileInputStream fis = new FileInputStream(fileName);
        int countWhiteSpaces = 0;
        int countOtherCharacters = 0;

        while (fis.available() > 0){
            char i = (char)fis.read();
            if(i == ' '){
                countWhiteSpaces += 1;
                countOtherCharacters += 1;
            }
            else{
                countOtherCharacters += 1;
            }
        }
        double rel = countWhiteSpaces*1.0/countOtherCharacters*100.0;
        System.out.println(df.format(rel));
        fis.close();
    }
}
