/*
Перевертыши
1. Считать с консоли имя файла. Считать содержимое файла.
2. Для каждой строки в файле:
2.1. переставить все символы в обратном порядке.
2.2. вывести на экран.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseString {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader fr = new BufferedReader(new FileReader(fileName));

        String line = "";

        while((line = fr.readLine()) != null){
            StringBuilder stringBuilder = new StringBuilder(line);
            stringBuilder.reverse();
            String reverseString = stringBuilder.toString();
            System.out.println(reverseString);
        }

        reader.close();
        fr.close();
    }
}
