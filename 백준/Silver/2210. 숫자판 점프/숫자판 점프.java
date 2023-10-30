import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] arr = new int[5][5];
    private static Set<String> digits = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bfs(i, j, String.valueOf(arr[i][j]));
            }
        }

        System.out.println(digits.size());
    }

    private static void bfs(int x, int y, String digit) {
        if (digit.length() == 6) {
            digits.add(digit);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int moveX = dx[i] + x;
            int moveY = dy[i] + y;
            if (moveX < 0 || moveY < 0 || moveX >= 5 || moveY >= 5) continue;

            bfs(moveX, moveY, digit + arr[moveX][moveY]);
        }

    }
}


