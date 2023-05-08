import java.util.*;

public class Main {

    static int N;
    static int[][] map;
    static boolean visited[];
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            dfs(0, i, i, 0);
            visited[i] = false;
        }

        System.out.println(answer);
    }

    // 깊이, 시작도시, 이전도시, 비용, 방문여부
    private static void dfs(int depth, int start, int prev, int sum) {
        if (depth == N - 1) {
            if (map[prev][start] != 0) {
                answer = Math.min(answer, sum + map[prev][start]); // 다시 돌아오면 플러스
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i] && map[prev][i] != 0) {
                visited[i] = true;
                dfs(depth + 1, start, i, sum + map[prev][i]);
                visited[i] = false;
            }
        }
    }
}
