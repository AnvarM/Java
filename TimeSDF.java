import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeSDF {
    public static void main(String[] args)  throws ParseException {
        Date dt = new Date();
        SimpleDateFormat sdf0 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(sdf0.format(dt)); //format date object to string with format yyyy-MM-dd
        System.out.println(sdf1.format(dt));
        System.out.println(sdf0.parse("1990-01-02")); //parse string to date object with pattern yyyy-MM-dd
    }
}
