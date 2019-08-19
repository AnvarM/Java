import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно.
Например, 0 - "ноль", 1 - "один", 2 - "два"
2. Считать с консоли имя файла, считать содержимое файла.
3. Заменить все числа на слова используя словарь map.
4. Результат вывести на экран.
5. Закрыть потоки.
*/

public class NumbersToWords {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static{
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader( new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedReader fr = new BufferedReader(new FileReader(fileName));

        String line = "";

        while((line = fr.readLine()) != null){
            String[] temp = line.split(" ");
            for(int i = 0; i < temp.length; i++){
                try{
                    int tmp = Integer.parseInt(temp[i]);
                    if(map.keySet().contains(tmp)){
                        temp[i] = map.get(tmp);
                    }
                }
                catch (Exception e){
                }
            }
            String str = "";
            for (String s : temp){
                str += s + " ";
            }
            System.out.println(str.substring(0, str.length()-1));
        }
        reader.close();
        fr.close();
    }

}
