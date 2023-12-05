import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    static boolean[] visited;
    static int n, m, max;


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(max);
    }


    static void dfs(int start, int count) {
        if (count == 3) {

            int sum = 0;
            for (int i = 0; i < n; i++) {
                int maxHappy = 0;
                for (int j = 0; j < m; j++) {
                    if (visited[j]) maxHappy = Math.max(maxHappy, arr[i][j]);
                }
                sum += maxHappy;
            }

            max = Math.max(sum, max);
            return;
        }

        for (int i = start; i < m; i++) {
            visited[i] = true;
            dfs(i + 1, count + 1);
            visited[i] = false;
        }

    }
}
