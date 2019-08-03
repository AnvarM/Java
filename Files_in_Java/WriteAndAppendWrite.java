package Files_in_Java;

//считать 2 файла, записать сперва второй в первый, а потом третий дозаписать в первый
import java.io.*;

public class WriteAndAppendWrite {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();
        String filename3 = reader.readLine();

        FileInputStream fis1 = new FileInputStream(filename2);
        FileInputStream fis2 = new FileInputStream(filename3);
        FileOutputStream fos = new FileOutputStream(filename1, true); // true - значит что поток открыт на дозапись

        while (fis1.available() > 0){
            int i = fis1.read();
            fos.write(i);
        }

        while (fis2.available() > 0){
            int i = fis2.read();
            fos.write(i);
        }

        fis1.close();
        fis2.close();
        fos.close();
    }
}