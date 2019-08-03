import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JFileReader {
    public static void main(String[] args) throws IOException {
    String currentDirectory = System.getProperty("user.dir");
    System.out.println(currentDirectory);
    BufferedReader reader = new BufferedReader(new FileReader(currentDirectory +"\\1.txt"));

    String line = "";

    while((line = reader.readLine()) != null){
            System.out.println(line);
        }
    }
}
