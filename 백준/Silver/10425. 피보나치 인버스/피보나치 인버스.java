import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = toInt(br.readLine());

        BigInteger[] fibonachi = new BigInteger[100001];
        fibonachi[0] = BigInteger.valueOf(0);
        fibonachi[1] = BigInteger.valueOf(1);
        for (int i = 2; i < 100001; i++) {
            fibonachi[i] = fibonachi[i - 1].add(fibonachi[i - 2]);
        }

        while (T-- > 0) {
            BigInteger N = new BigInteger(br.readLine());
            for (int i = 2; i < 100001; i++) {
                if (N.equals(fibonachi[i])) {
                    sb.append(i).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }

    static int toInt(String s) {
        return Integer.parseInt(s);
    }

    static long toLong(String s) {
        return Long.parseLong(s);
    }
}
