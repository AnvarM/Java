import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter {
    public static void main(String[] args){
        try{
            FileInputStream fis = new FileInputStream("1.txt");
            FileOutputStream fos = new FileOutputStream("2.txt");

            byte[] bufer = new byte[8];

            while(fis.available() > 0){
                int count = fis.read(bufer); //read 8 bytes to bufer array, assign amount of read sysbols to var count
                System.out.println(count);
                fos.write(bufer, 0, count); //write array buffer from the begin till last symbol
            }

            fis.close();
            fos.close();
        }
        catch (IOException e){
            System.out.println(e);
        }
    }

}
