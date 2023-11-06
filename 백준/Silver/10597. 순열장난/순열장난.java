import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N;
    private static boolean[] visited;
    private static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        N = s.length() < 10 ? s.length() : 9 + (s.length() - 9) / 2;
        visited = new boolean[N + 1];

        dfs(0, new StringBuilder());

    }

    private static void dfs(int idx, StringBuilder sb) {
        if (idx >= s.length()) {
            if (isSuccess()) {
                System.out.println(sb.toString().trim());
                System.exit(0);
            }
            return;
        }


        if (idx < s.length()) {
            String tmp = s.substring(idx, idx + 1);
            int num = Integer.parseInt(tmp);

            if (!visited[num]) {
                visited[num] = true;
                dfs(idx + 1, new StringBuilder(sb).append(num).append(" "));
                visited[num] = false;
            }
        }

        if (idx < s.length() - 1) {
            String tmp = s.substring(idx, idx + 2);
            int num = Integer.parseInt(tmp);

            if (isRangeCheck(tmp) && !visited[num]) {
                visited[num] = true;
                dfs(idx + 2, new StringBuilder(sb).append(num).append(" "));
                visited[num] = false;
            }
        }
    }


    private static boolean isSuccess() {
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) return false;
        }
        return true;
    }

    private static boolean isRangeCheck(String num) {
        int check = Integer.parseInt(num);
        return check >= 10 && check <= N;
    }
}





