import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    private static int[][] map;
    private static boolean[][] visited;

    private static int N;
    private static int M;

    private static int count = 0;

    private static int[] moveX = new int[]{-1, 1, 0, 0};
    private static int[] moveY = new int[]{0, 0, 1, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {

            String s = br.readLine();

            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == 'W') {
                    map[i][j] = 1;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        long myTeamCount = 0;
        long otherTeamCount = 0;

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    int count = dfs(i, j);

                    if (map[i][j] == 1) {
                        myTeamCount += (long) count * count;
                    } else {
                        otherTeamCount += (long) count * count;
                    }
                }
                count = 0;
            }
        }

        System.out.println(myTeamCount + " " + otherTeamCount);
    }

    public static int dfs(int x, int y) {

        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {

            if (x + moveX[i] < 0 || y + moveY[i] < 0 || x + moveX[i] >= N || y + moveY[i] >= M) {
                continue;
            }

            if (!visited[x + moveX[i]][y + moveY[i]] && map[x + moveX[i]][y + moveY[i]] == map[x][y]) {
                dfs(x + moveX[i], y + moveY[i]);
            }
        }

        return count;
    }
}


