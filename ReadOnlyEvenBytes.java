/* 
Четные символы
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным порядковым номером (нумерация начинается с 1).
*/

import java.io.*;

public class ReadOnlyEvenBytes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputfile = reader.readLine();
        String outputfile = reader.readLine();

        FileReader r = new FileReader(inputfile);
        FileWriter w = new FileWriter(outputfile);

        while(r.ready()){
            int f = r.read();
            int s = r.read();
            w.write(s);
        }
        r.close();
        w.close();
        reader.close();
    }
}