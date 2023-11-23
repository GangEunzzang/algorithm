import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int caseNumber = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) break;

            parent = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }

            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                union(x, y);
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                int find = find(i);
                if (find > 0) set.add(find);
            }

            int treeCount = set.size();

            if (treeCount == 0) sb.append("Case " + caseNumber + ": No trees.");
            if (treeCount == 1) sb.append("Case " + caseNumber + ": There is one tree.");
            if (treeCount >= 2) sb.append("Case " + caseNumber + ": A forest of " + treeCount + " trees.");
            sb.append("\n");

            caseNumber++;
        }

        System.out.println(sb);

    }

    private static int find(int x) {
        if (x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x > y) {
            int tmp = x;
            x = y;
            y = tmp;
        }

        if (x == y) parent[x] = 0;
        else parent[y] = x;

    }
}