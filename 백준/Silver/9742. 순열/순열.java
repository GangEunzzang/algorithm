import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static String s;
    private static int length;
    private static int target;
    private static int count;
    private static String answer;
    private static boolean[] visited;

    private static char[] chars;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while ((line = br.readLine()) != null) {

            StringTokenizer st = new StringTokenizer(line);
            s = st.nextToken();
            answer = null;
            count = 0;
            length = s.length();
            target = Integer.parseInt(st.nextToken());
            chars = new char[s.length()];

            visited = new boolean[s.length()];

            dfs(0);

            answer = answer == null ? "No permutation" : answer;
            sb.append(s + " " + target + " = " + answer).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int cnt) {
        if (answer != null) return;

        if (cnt == s.length()) {
            count++;
            if (count == target) answer = new String(chars);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (visited[i] || answer != null) continue;

            visited[i] = true;
            chars[cnt] = s.charAt(i);
            dfs(cnt + 1);
            visited[i] = false;

        }
    }
}
