import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words.
Закрыть потоки
*/

public class ContainsOnlyTwoWordsFromList {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        BufferedReader fr = new BufferedReader(new FileReader(filename));

        String line = "";
        int count = 0;
        while((line = fr.readLine()) != null){
            String[] t = line.split(" ");
            for(String temp : t){
                if(words.contains(temp)){
                    count += 1;
                }
            }
            if(count == 2){
                System.out.println(line);
            }
            count = 0;
        }
        reader.close();
        fr.close();
    }
}