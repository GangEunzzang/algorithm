import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int INF = Integer.MAX_VALUE;
    static int N,M, T, result;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken());
        M = toInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = toInt(st.nextToken());
            }
        }

        T = toInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                calculate(i, j);
            }
        }

        System.out.println(result);
        
    }

    private static void calculate(int n, int m) {
        int dx = n + 3;
        int dy = m + 3;
        if (dx > N || dy > M) return;

        List<Integer> list = new ArrayList<>();

        for (int i = n; i < dx; i++) {
            for (int j = m; j < dy; j++) {
                list.add(arr[i][j]);
            }
        }

        Collections.sort(list);
        if (list.get(4) >= T) result++;
    }

    private static int toInt(String val) {
        return Integer.parseInt(val);
    }

}
