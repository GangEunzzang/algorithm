import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] arr;
    private static int minus, zero, one;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(0, 0, N);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);

    }

    private static void solve(int x, int y, int size) {

        if (colorCheck(x, y, size)) {
            if (arr[x][y] == -1) minus++;
            if (arr[x][y] == 0) zero++;
            if (arr[x][y] == 1) one++;
            return;
        }

        int newSize = size / 3;

        solve(x , y, newSize);
        solve(x + newSize, y, newSize);
        solve(x + newSize * 2, y, newSize);

        solve(x, y + newSize, newSize);
        solve(x + newSize, y + newSize, newSize);
        solve(x + newSize * 2, y + newSize, newSize);

        solve(x, y + newSize * 2, newSize);
        solve(x + newSize, y + newSize * 2, newSize);
        solve(x + newSize * 2, y + newSize * 2, newSize);

    }

    private static boolean colorCheck(int x, int y, int size) {

        int color = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if(arr[i][j] != color) return false;
            }
        }

        return true;
    }

}
