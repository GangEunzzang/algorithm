import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int index = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < index; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            graph.get(n1).add(n2);
            graph.get(n2).add(n1);
        }



        dfs(1);

        int count = 0;
        for (int i = 2; i < visited.length; i++) {
            if (visited[i]) {
                count++;
            }
        }
        System.out.println(count);

    }

    public static void dfs(int index) {

        if(visited[index]) {
            return;
        }

        visited[index] = true;

        List<Integer> node = graph.get(index);

        for (Integer i : node) {
            if (!visited[i]) {
                dfs(i);
            }
        }

    }
}
