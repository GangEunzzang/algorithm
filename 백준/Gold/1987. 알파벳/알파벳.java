import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static int R;
    private static int C;

    private static int[] moveR = {-1, 1, 0, 0};
    private static int[] moveC = {0, 0, -1, 1};

    private static int max;

    private static char[][] board;
    private static boolean[][] visited;
    private static Set<Character> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        visited = new boolean[R][C];
        set = new HashSet<>();

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        dfs(0, 0, 1);
        System.out.println(max);
    }

    private static void dfs(int x, int y, int count) {
        visited[x][y] = true;
        set.add(board[x][y]);
        if (count > max) {
            max = count;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + moveR[i];
            int nextY = y + moveC[i];

            if (nextX < 0 || nextY < 0 || nextX >= R || nextY >= C) {
                continue;
            }

            char nextChar = board[nextX][nextY];
            if (!visited[nextX][nextY] && !set.contains(nextChar)) {
                dfs(nextX, nextY, count + 1);
            }
        }

        visited[x][y] = false;
        set.remove(board[x][y]);
    }
}
