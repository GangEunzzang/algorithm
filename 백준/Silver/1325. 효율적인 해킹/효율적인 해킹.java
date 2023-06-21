import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int max;
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) -1;
            int b = Integer.parseInt(st.nextToken()) -1;
            graph.get(b).add(a);
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            bfs(i);
        }

        System.out.println(answer);
    }

    static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        int result = 0;
        visited[num] = true;

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            List<Integer> list = graph.get(poll);
            for (Integer i : list) {
                if(visited[i]) continue;
                visited[i] = true;
                result++;
                q.add(i);
            }
        }

        if (result > max) {
            max = result;
            answer.setLength(0);
            answer.append(num + 1).append(" ");
        } else if (max == result) {
            answer.append(num + 1).append(" ");
        }
    }
}
