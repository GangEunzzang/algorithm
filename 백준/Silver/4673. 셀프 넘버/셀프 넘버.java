import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        boolean[] arr = new boolean[10001];

        for (int i = 1; i <= 10000; i++) {
            int calculate = calculate(i);
            if (calculate <= 10000) {
                arr[calculate] = true;
            }
        }

        for (int i = 1; i <= 10000; i++) {
            if (!arr[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);

    }

    private static int calculate(int num) {
        int result = num;
        while (num != 0) {
            result += num % 10;
            num /= 10;
        }

        return result;
    }


}
