
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UrlAttributesParser {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        int beginSubstring = url.indexOf("?");
        String strForParsing = url.substring(beginSubstring + 1);
        ArrayList<String> attributesWithValues = new ArrayList<String>();

        while(true){
            if(strForParsing.indexOf("&") == -1){
                String attrv = strForParsing.substring(0);
                attributesWithValues.add(attrv);
                break;
            }
            else{
                String attrv = strForParsing.substring(0,strForParsing.indexOf("&"));
                attributesWithValues.add(attrv);
                strForParsing = strForParsing.substring(strForParsing.indexOf("&") + 1);
            }
        }

        ArrayList<String> attributes = new ArrayList<String>();
        for (String st : attributesWithValues){
            if (st.indexOf("=") == -1){
                attributes.add(st);
            }
            else{
                st = st.substring(0, st.indexOf("="));
                attributes.add(st);
            }
        }

        for (String s : attributes){
            System.out.print(s + " ");
        }

        System.out.println();

        for (String s : attributesWithValues){
            System.out.println(s);
        }
    }
}

