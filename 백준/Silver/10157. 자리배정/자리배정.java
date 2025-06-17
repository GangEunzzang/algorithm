import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int C,R,K;
    static int[][] visited;
    static int[] dirX = {-1, 0, 1, 0};
    static int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        C = toInt(st.nextToken());
        R = toInt(st.nextToken());
        K = toInt(br.readLine());

        visited = new int[R][C];

        if (K > C * R) {
            System.out.println(0);
        } else {
            solution();
        }


    }

    private static void solution() {
        int curX = R ;
        int curY = 0;
        int curDirection = 0;
        int cur = 1;

        while (K-- > 0) {
            int moveX = curX + dirX[curDirection];
            int moveY = curY + dirY[curDirection];

            if (moveX < 0 || moveY < 0 || moveX >= R || moveY >= C || visited[moveX][moveY] != 0) {
                curDirection = (curDirection + 1) % 4;
                K++;
                continue;
            }

            curX = moveX;
            curY = moveY;
            
            visited[moveX][moveY] = cur++;
        }
        
        System.out.println((curY + 1) + " " + (R - curX));
    }


    static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
