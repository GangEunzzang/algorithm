import java.io.*;
import java.util.*;


public class Main {

    static int INF = 2_000_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, N, cycle;
    static int[] parent, arr;

    public static void main(String[] args) throws IOException {
        T = toInt(br.readLine());

        while (T-- > 0) {
            cycle = 0;
            N = toInt(br.readLine());
            parent = new int[N + 1];
            arr = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                union(i, toInt(st.nextToken()));
            }

            System.out.println(cycle);

        }


    }

    static int find(int x) {
        if (parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            cycle++;
        } else if (x > y) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }



    static int toInt(String val) {
        return Integer.parseInt(val);
    }
}

