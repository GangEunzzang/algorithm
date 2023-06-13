import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static int[] arr;
    private static boolean[] visited;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        arr = new int[s.length()];
        visited = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            arr[i] = s.charAt(i) - '0';
        }

        N = Integer.parseInt(s);
        dfs(0, 0);
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }

    private static void dfs(int idx, int num) {
        if (idx == arr.length) {
            if (num > N && num < min) min = num;
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            dfs(idx + 1, (num * 10) + arr[i]);
            visited[i] = false;
        }
    }
}
