import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = toInt(br.readLine());

        while (T-- > 0) {
            int N = toInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int sum = 0;
            for (int i = 0; i < 6; i++) {
                sum += toInt(st.nextToken());
            }

            int day = 1;

            while (sum <= N) {
                sum *= 4;
                day++;
            }

            sb.append(day).append("\n");
        }

        System.out.println(sb);
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }
}
