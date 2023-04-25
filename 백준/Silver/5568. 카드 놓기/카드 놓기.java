import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static int n, k;
    static String[] arr;
    static Set<String> set = new HashSet<>();

    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new String[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        dfs(0, 0, "");
        System.out.println(set.size());
    }

    static void dfs(int i, int depth, String num) {

        if (depth == k) {
            set.add(num);
            return;
        }

        if (i >= n) {
            return;
        }

        IntStream.range(0, n).filter(j -> !visited[j]).forEachOrdered(j -> {
            visited[j] = true;
            dfs(j, depth + 1, num + arr[j]);
            visited[j] = false;
        });
    }
}