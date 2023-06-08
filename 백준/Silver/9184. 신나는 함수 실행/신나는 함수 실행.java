import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int a;
    private static int b;
    private static int c;

    private static Map<String, Integer> dp = new HashMap<>();

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) break;

            sb.append("w(" + a + ", " + b + ", " + c + ")").append(" = ").append(w(a, b, c)).append("\n");

        }

        System.out.println(sb);

    }

    public static int w(int a, int b, int c) {
        String key = a + "," + b + "," + c;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        if (a <= 0 || b <= 0 || c <= 0) {
            dp.put(key, 1);
        } else if (a > 20 || b > 20 || c > 20) {
            dp.put(key, w(20, 20, 20));
        } else if (a < b && b < c) {
            int result = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            dp.put(key, result);
        } else {
            int result = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
            dp.put(key, result);
        }

        return dp.get(key);
    }
}
