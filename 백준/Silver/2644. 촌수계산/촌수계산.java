import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;

    static int one;
    static int two;

    static boolean check;

    static int count = -1;

    static boolean[] visited;

    static List<List<Integer>> nodeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        one = Integer.parseInt(st.nextToken());
        two = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            nodeList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            nodeList.get(x).add(y);
            nodeList.get(y).add(x);
        }

        dfs(one,two,0);

        System.out.println(count);
    }

    public static void dfs(int start, int end, int cnt) {

        if (start == two) {
            count = cnt;
            return;
        }

        if (visited[start]) {
            return;
        }

        visited[start] = true;

        List<Integer> nodes = nodeList.get(start);

        for (Integer node : nodes) {
            if (!visited[node]) {
                dfs(node, two, cnt +1);
            }
        }
    }

}

