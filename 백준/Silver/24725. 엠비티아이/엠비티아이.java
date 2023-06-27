import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static char[][] arr;
    private static int[] moveX = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] moveY = {0, 1, 1, 1, 0, -1, -1, -1};
    private static int answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'I' || arr[i][j] == 'E') {
                    search(i,j);
                }
            }
        }

        System.out.println(answer);
    }

    private static void search(int x, int y) {

        for (int i = 0; i < 8; i++) {

            int nowX = x;
            int nowY = y;

            for (int j = 1; j <= 3; j++) {
                int mx = moveX[i] + nowX;
                int my = moveY[i] + nowY;

                if (mx < 0 || my < 0 || mx >= N || my >= M) break;
                char c = arr[mx][my];

                if (j == 1 && (c == 'S' || c == 'N')) {
                    nowX = mx;
                    nowY = my;
                } else if (j == 2 && (c == 'T' || c == 'F')) {
                    nowX = mx;
                    nowY = my;
                } else if (j == 3 && (c == 'P' || c == 'J')) {
                    nowX = mx;
                    nowY = my;
                    answer++;
                } else {
                    break;
                }

                nowX = mx;
                nowY = my;


            }

        }

    }

}