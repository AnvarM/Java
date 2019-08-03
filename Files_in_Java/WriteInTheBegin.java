package Files_in_Java;

//Записать файл 2 в начало файла 1

import java.io.*;

public class WriteInTheBegin {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();

        FileInputStream fis1 = new FileInputStream(filename1);
        FileOutputStream fos1 = new FileOutputStream(filename1);
        FileInputStream fis2 = new FileInputStream(filename2);
        int file_len1 = fis1.available();
        byte[] buffer1 = new byte[file_len1];
        fis1.read(buffer1);

        int file_len2 = fis2.available();
        byte[] buffer2 = new byte[file_len2]; //create bytes buffer with length of file2
        fis2.read(buffer2); //read fis2 to buffer

        fos1.write(buffer2);
        fos1.write(buffer1);

        fis1.close();
        fis2.close();
        fos1.close();
    }
}