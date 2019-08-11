import java.util.ArrayList;

public class ArrTest {
    public static void main(String[] args){
        String[] tArr = new String[]{"test", "test1", "test2"};
        ArrayList<String> rlst = new ArrayList<>();
        for(String s: tArr){
            rlst.add(s);
        }
        System.out.println(rlst.contains("test"));
    }
}
