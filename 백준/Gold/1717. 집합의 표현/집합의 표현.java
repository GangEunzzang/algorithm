import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static int[] union;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        union = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            union[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int check = Integer.parseInt(st.nextToken());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 합집합 연산
            if (check == 0) {
                union(x, y);
            }

            // 집합 확인
            if (check == 1) {
                sb.append(find(x) == find(y) ? "YES" : "NO").append("\n");
            }

        }

        System.out.println(sb);


    }

    private static int find(int x) {
        if (x == union[x]) return x;

        return union[x] = find(union[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            union[y] = x;
        } else {
            union[x] = y;
        }

    }


}