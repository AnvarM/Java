package Files_in_Java;

//Посчитать количество английских букв в файле, указанном в аргументе
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;


public class CountEnglishLetters {
    public static void main(String[] args) throws IOException {
        char[] starr = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q'
                , 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z','A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
                'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

        ArrayList<Character> charr = new ArrayList<Character>();

        for(char ch : starr){
            charr.add(ch); //fill arraylist with chars
        }

        int letterCounter = 0;

        String fileName = args[0];

        FileInputStream fis = new FileInputStream(fileName);

        while (fis.available() > 0){
            if (charr.contains((char)fis.read())){
                letterCounter += 1;
            }
        }

        System.out.println(letterCounter);
        fis.close();
    }

}