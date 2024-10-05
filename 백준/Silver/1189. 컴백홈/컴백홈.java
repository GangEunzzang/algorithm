import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int R,C,K,result;
    static int[][] arr;
    static boolean[][] visited;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        R = toInt(st.nextToken());
        C = toInt(st.nextToken());
        K = toInt(st.nextToken());

        arr = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                if (s.charAt(j) == 'T') {
                    arr[i][j] = -1;
                }
            }
        }
        
        visited[R-1][0] = true;
        search(R - 1, 0, 1);

        System.out.println(result);
    }

    static void search(int x, int y, int count) {
        if (x == 0 && y == C - 1) {
            if (count == K) result++;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int mx = x + moveX[i];
            int my = y + moveY[i];

            if (mx < 0 || my < 0 || mx >= R || my >= C || count > K || arr[mx][my] == -1 || visited[mx][my]) continue;
            visited[mx][my] = true;
            search(mx, my, count + 1);
            visited[mx][my] = false;
        }
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }
}
