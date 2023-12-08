import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, min = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        N = toInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = toInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(min);

    }

    static void dfs(int start, int teamCount) {
        if (teamCount == N / 2) {
            teamDiffCalculate();
            return;
        }

        for (int i = start; i < N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            dfs(i, teamCount + 1);
            visited[i] = false;
        }

    }


    static void teamDiffCalculate() {
        int team1Sum = 0;
        int team2Sum = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                if (visited[i] && visited[j]) {
                    team1Sum += arr[i][j];
                }

                if (!visited[i] && !visited[j]) {
                    team2Sum += arr[i][j];
                }
            }
        }

        min = Math.min(min, Math.abs(team1Sum - team2Sum));
    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}
