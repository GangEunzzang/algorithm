import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, C, H, K;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(x, y);
        }


        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken()); // CTP 왕국
        H = Integer.parseInt(st.nextToken()); // 한솔 왕국
        K = Integer.parseInt(st.nextToken()); // 동맹 횟수


        int[] counts = new int[N + 1];

        int sum = 0;

        for (int i = 1; i <= N; i++) {
            if (find(H) == find(i)) continue;
            if (find(C) == find(i)) {
                sum++;
                continue;
            }
            counts[find(i)]++;
        }


        counts = Arrays.stream(counts).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();


        for (int count : counts) {
            if (K-- > 0) {
                sum += count;
            } else {
                break;
            }
        }


        System.out.println(sum);

    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x > y) {
                parent[x] = y;
            } else {
                parent[y] = x;
            }
        }
    }

}
