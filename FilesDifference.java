import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Отслеживаем изменения
Считать с консоли 2 имени файла - file1, file2.
Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
Нужно создать объединенную версию строк, записать их в список lines.
Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
*/

public class FilesDifference {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();

        BufferedReader fr1 = new BufferedReader(new FileReader(f1));
        BufferedReader fr2 = new BufferedReader(new FileReader(f2));

        ArrayList<String> strf1 = new ArrayList<>();
        ArrayList<String> strf2 = new ArrayList<>();

        String l1 = "";
        String l2 = "";

        while((l1 = fr1.readLine()) != null){
            strf1.add(l1);
        }

        while((l2 = fr2.readLine()) != null){
            strf2.add(l2);
        }

        try {
            while (strf1.size() >= 0 && strf2.size() >=0) {
                if (strf1.get(0).equals(strf2.get(0))) {
                    lines.add(new LineItem(Type.SAME, strf1.get(0)));
                    strf1.remove(0);
                    strf2.remove(0);

                }
                else if (!strf1.get(0).equals(strf2.get(0)) && strf2.size() > 1) {
                    if(strf1.get(0).equals(strf2.get(1))) {
                        lines.add(new LineItem(Type.ADDED, strf2.get(0)));
                        strf2.remove(0);
                    }
                    else if(!strf1.get(0).equals(strf2.get(1))) {
                        lines.add(new LineItem(Type.REMOVED, strf1.get(0)));
                        strf1.remove(0);
                    }
                }
                else {
                    lines.add(new LineItem(Type.REMOVED, strf1.get(0)));
                    strf1.remove(0);
                }
            }


        }
        catch (IndexOutOfBoundsException e){
            if(strf1.size() > 0){
                lines.add(new LineItem(Type.REMOVED, strf1.get(0)));
                strf1.remove(0);
            }
            else if(strf2.size() > 0){
                lines.add(new LineItem(Type.ADDED, strf2.get(0)));
                strf2.remove(0);
            }
        }

        for(LineItem l : lines){
            System.out.println(l.type + ": " + l.line);
        }

        fr1.close();
        fr2.close();
        reader.close();

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
