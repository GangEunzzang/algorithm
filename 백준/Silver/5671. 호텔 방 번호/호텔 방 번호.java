import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        while (true) {
            String s = br.readLine();
            if(s == null || s.isBlank()) break;

            st = new StringTokenizer(s);
            int N = toInt(st.nextToken());
            int M = toInt(st.nextToken());

            int count = 0;
            for (int i = N; i <= M; i++) {
                if (checkRepeatNumber(i)) {
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    static boolean checkRepeatNumber(int n) {
        boolean[] check = new boolean[10];
        while (n > 0) {
            if (check[n % 10]) {
                return false;
            }
            check[n % 10] = true;
            n /= 10;
        }
        return true;
    }
    static int toInt(String s) {
        return Integer.parseInt(s);
    }

}
