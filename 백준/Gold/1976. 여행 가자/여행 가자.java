import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer  st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int check = Integer.parseInt(st.nextToken());
                if (check == 1) {
                    union(i, j);
                }
            }
        }


        StringTokenizer st = new StringTokenizer(br.readLine());
        int tmp = Integer.parseInt(st.nextToken());
        m--;
        while (m-- > 0) {
            if (find(tmp) != find(Integer.parseInt(st.nextToken()))) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");

    }

    private static int find(int x) {
        if (x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }

    }


}