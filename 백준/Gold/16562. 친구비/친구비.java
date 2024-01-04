import javax.swing.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {

    static int INF = 1_000_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, k;
    static int[] parent;
    static int[] cost;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken());
        M = toInt(st.nextToken());
        k = toInt(st.nextToken());
        parent = new int[N + 1];
        cost = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = toInt(st.nextToken());
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            union(toInt(st.nextToken()), toInt(st.nextToken()));
        }


        boolean[] check = new boolean[N + 1];

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            int idx = find(i);

            if (check[idx]) {
                check[i] = true;
                continue;
            }

            sum += cost[idx];
            check[idx] = true;
            check[i] = true;

        }

        System.out.println(sum > k ? "Oh no" : sum);

    }


    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (cost[x] >= cost[y]) {
            parent[x] = y;
        } else {
            parent[y] = x;
        }
    }

    static int toInt(String val) {
        return Integer.parseInt(val);
    }

}




