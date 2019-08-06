package Files_in_Java;

/*
update и delete строчки из списка файлов, строчки одинаковой длины, при указании в аргументах:
    -d id - удаляет строчку из файла
    -u id name price quantity - обновляет строчку в файле с указанным id данными указанными в аргументах
*/

import java.io.*;
import java.util.ArrayList;

public class UpdateDeleteStringInFile {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        if (args.length == 0) {
            return;
        }
        else if (args.length == 5 && args[0].equals("-u")) {
            String id = String.format("%-8s", args[1]);
            String name = String.format("%-30s", args[2]);
            String price = String.format("%-8s", args[3]);
            String quantity = String.format("%-4s", args[4]);

            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

            String line = "";
            ArrayList<String> strngs = new ArrayList<>();

            while((line = fileReader.readLine()) != null){
                if(!(line.substring(0,8).equals(id))){
                    strngs.add(line);
                }
                else{
                    String towrite = line.substring(0,8) + name + price + quantity;
                    strngs.add(towrite);
                }
            }

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
            for(String s : strngs){
                fileWriter.write(s + "\n");
            }

            fileReader.close();
            fileWriter.close();
        }

        else if (args.length == 2 && args[0].equals("-d")) {
            String id = String.format("%-8s", args[1]);
            BufferedReader fileReader = new BufferedReader(new FileReader(fileName));

            String line = "";
            ArrayList<String> strngs = new ArrayList<>();

            while((line = fileReader.readLine()) != null){
                if(!(line.substring(0,8).equals(id))){
                    strngs.add(line);
                }
                else{

                }
            }

            BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
            for(String s : strngs){
                fileWriter.write(s + "\n");
            }

            fileReader.close();
            fileWriter.close();

        }
    }
}


