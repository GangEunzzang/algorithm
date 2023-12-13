import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> tree = new ArrayList<>();
    static int N = 10;
    static char[][] arr = new char[10][10];
    static int[] moveX = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] moveY = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == '.' && check(i, j)) {
                    System.out.println(1);
                    return;
                }
            }
        }

        System.out.println(0);

    }

    static boolean check(int x, int y) {

        // 가로 탐색
        int count = 0;
        for (int i = 1; i <= 10; i++) {
            int my = y - i;
            if (my < 0 || arr[x][my] != 'X') break;
            count++;
        }

        for (int i = 1; i <= 10; i++) {
            int my = y + i;
            if (my >= 10 || arr[x][my] != 'X') break;
            count++;
        }

        if (count >= 4) return true;

        //세로 탐색
        count = 0;
        for (int i = 1; i <= 10; i++) {
            int mx = x - i;
            if (mx < 0 || arr[mx][y] != 'X') break;
            count++;
        }

        for (int i = 1; i <= 10; i++) {
            int mx = x + i;
            if (mx >= 10 || arr[mx][y] != 'X') break;
            count++;
        }

        if (count >= 4) return true;

        // 왼쪽 대각 탐색
        count = 0;
        for (int i = 1; i <= 10; i++) {
            int mx = x - i;
            int my = y - i;
            if (mx < 0 || my < 0 || arr[mx][my] != 'X') break;
            count++;
        }

        for (int i = 1; i <= 10; i++) {
            int mx = x + i;
            int my = y + i;
            if (mx >= 10 || my >= 10 || arr[mx][my] != 'X') break;
            count++;
        }

        if (count >= 4) return true;

        // 오른쪽 대각 탐색
        count = 0;
        for (int i = 1; i <= 10; i++) {
            int mx = x - i;
            int my = y + i;
            if (mx < 0 || my >= 10 || arr[mx][my] != 'X') break;
            count++;
        }

        for (int i = 1; i <= 10; i++) {
            int mx = x + i;
            int my = y - i;
            if (mx >= 10 || my < 0 || arr[mx][my] != 'X') break;
            count++;
        }

        if (count >= 4) return true;


        return false;
    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}

