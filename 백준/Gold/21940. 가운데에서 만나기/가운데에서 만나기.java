import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] graph;
    static int N, M, C;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken());
        graph = new int[N + 1][N + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }

        M = toInt(st.nextToken());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = toInt(st.nextToken());
            int b = toInt(st.nextToken());
            int c = toInt(st.nextToken());
            graph[a][b] = Math.min(graph[a][b], c);
        }

        // k -> 중간 노드
        // i -> 시작 노드
        // j -> 도착 노드

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (graph[i][k] == Integer.MAX_VALUE || graph[k][j] == Integer.MAX_VALUE) continue;
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

        C = toInt(br.readLine());
        List<Integer> liveNumbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> answers = new ArrayList<>();

        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            int now = 0;
            for (Integer number : liveNumbers) now = Math.max(graph[i][number] + graph[number][i], now);

            if (min < now) continue;
            if (min == now) {
                answers.add(i);
                continue;
            }

            answers.clear();
            min = now;
            answers.add(i);

        }
        
        Collections.sort(answers);

        for (Integer answer : answers) {
            sb.append(answer).append(" ");
        }

        System.out.println(sb);

    }

    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}

