package Files_in_Java;

import java.io.*;
import java.util.*;

/*
Собираем файл из кусочков.
Считываем с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.

Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создаем файл без суффикса [.partN].
Файлы переписываем в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.

*/

public class FileAssembler {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        ArrayList<String> fileNames = new ArrayList<String>();
        while(!(fileName = reader.readLine()).equals("end")){
            fileNames.add(fileName);
        }

        System.out.println(fileNames);

        String partName = fileNames.get(0).substring(fileNames.get(0).indexOf("part"), fileNames.get(0).length());
        String correctName = fileNames.get(0).substring(0,fileNames.get(0).indexOf("part") - 1);
        FileOutputStream fos = new FileOutputStream(correctName, true);

        HashMap<Integer, byte[]> buffers = new HashMap<>();
        for(String fn : fileNames){
            int partNumber = Integer.parseInt(fn.substring(fn.indexOf("part") + 4, fn.length()));
            FileInputStream fis = new FileInputStream(fn);
            byte[] tempbuf = new byte[fis.available()];
            fis.read(tempbuf);
            buffers.put(partNumber, tempbuf);
            fis.close();
        }
        ArrayList<Integer> prtnmbrs = new ArrayList<>();
        for(HashMap.Entry<Integer, byte[]> p : buffers.entrySet()){
            prtnmbrs.add(p.getKey());
        }

        Collections.sort(prtnmbrs);

        for(int i : prtnmbrs){
            fos.write(buffers.get(i));
        }
        fos.close();
    }
}
