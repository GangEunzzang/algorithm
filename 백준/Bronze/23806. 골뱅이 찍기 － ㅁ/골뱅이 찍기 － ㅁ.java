import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        String repeat = "@".repeat(Math.max(0, 5 * n));
        for (int i = 0; i < n; i++) {
            sb.append(repeat);
            sb.append('\n');
        }
        for (int i = 0; i < 3 * n; i++) {
            sb.append("@".repeat(Math.max(0, n)));
            sb.append(" ".repeat(Math.max(0, 3 * n)));
            sb.append("@".repeat(Math.max(0, n)));
            sb.append('\n');
        }
        for (int i = 0; i < n; i++) {
            sb.append(repeat);
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }
}