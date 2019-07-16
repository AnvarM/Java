import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/*
Факториал
*/

public class Factorial {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static BigInteger factorial(int n) {
        if (n < 0){
            return BigInteger.valueOf(0);
        }
        else if (n == 0 || n == 1){
            return BigInteger.valueOf(1);
        }
        else{
            BigInteger result = BigInteger.valueOf(n);
            for(int i = n - 1; i > 0; i--){
                BigInteger t = BigInteger.valueOf(i);
                result  = result.multiply(t);
            }
            return result;
        }

    }
}
