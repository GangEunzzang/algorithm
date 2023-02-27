import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {

    private static BigInteger[] arr = new BigInteger[10000 + 1];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(N == 0 ? 0 :  fibonaci(N));
        
    }

    private static BigInteger fibonaci(int num) {

        if (num == 1 || num == 2) {
            return BigInteger.valueOf(1);
        }

        BigInteger bigInteger = arr[num];

        if (bigInteger != null ) {
            return bigInteger;
        }

        BigInteger val = fibonaci(num - 1).add(fibonaci(num - 2));
        arr[num] = val;

        return val;

    }
}
