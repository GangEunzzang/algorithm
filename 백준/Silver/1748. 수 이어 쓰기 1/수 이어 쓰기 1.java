import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = toInt(br.readLine());
        int answer = 0;
        int a = 1;
        int b = 10;

        for (int i = 1; i <= n; i++) {
            if (i % b == 0) {
                a += 1;
                b *= 10;
            }
            answer += a;
        }

        System.out.println(answer);
    }

    static int toInt(String s) {
        return Integer.parseInt(s);
    }
}