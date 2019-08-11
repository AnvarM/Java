/*Слова с цифрами
        В метод main первым параметром приходит имя файла1, вторым - файла2.
        Файл1 содержит строки со словами, разделенными пробелом.
        Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
        Закрыть потоки.
        */

import java.io.*;

public class WordsContainsDigits {
    public static void main(String[] args) throws IOException {

        String file1 = args[0];
        String file2 = args[1];

        BufferedReader fr = new BufferedReader(new FileReader(file1));
        BufferedWriter fw = new BufferedWriter(new FileWriter(file2));

        String line = "";
        while((line = fr.readLine()) != null){
            String[] temp = line.split(" ");
            for(String t : temp){
                if(t.matches(".*\\d+.*")){
                    fw.write(t+ " ");
                }
            }
        }

        fr.close();
        fw.close();

    }
}