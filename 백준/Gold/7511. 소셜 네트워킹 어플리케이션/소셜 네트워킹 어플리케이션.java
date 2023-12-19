import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, K, M;
    static int[] parent;


    public static void main(String[] args) throws IOException {

        int T = toInt(br.readLine());
        int idx = 1;

        while (T --> 0) {

            sb.append("Scenario " + idx++ + ":" + "\n");

            N = toInt(br.readLine());
            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            K = toInt(br.readLine());
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = toInt(st.nextToken());
                int y = toInt(st.nextToken());
                union(x, y);
            }

            M = toInt(br.readLine());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int x = toInt(st.nextToken());
                int y = toInt(st.nextToken());
                sb.append(find(x) == find(y) ? 1 : 0);
                sb.append("\n");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    static int find(int x) {
        if (parent[x] == x) return x;

        return find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x > y) parent[x] = y;
        else parent[y] = x;
    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}

