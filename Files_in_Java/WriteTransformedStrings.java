package Files_in_Java;

//дан файл с записанными через пробел вещественными числами, записать во второй файл эти числа округленные до целых через пробел

import java.io.*;

public class WriteTransformedStrings {
    public static void main(String[] args) throws IOException {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = reader.readLine();
        String filename2 = reader.readLine();

        BufferedReader filereader = new BufferedReader(new FileReader(filename1));
        BufferedWriter filewriter = new BufferedWriter(new FileWriter(filename2));

        int counter = 0;
        String line = "";
        double f = 0.0;

        while((line = filereader.readLine()) != null){
            String[] d = line.split(" ");
            for(String s : d){
                float a = Float.parseFloat(s);
                int ra = Math.round(a);
                filewriter.write(ra + " ");
            }
        }

        filereader.close();
        filewriter.close();
    }
}