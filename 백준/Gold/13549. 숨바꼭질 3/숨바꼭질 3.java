import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int K;
    private static int[] visited = new int[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
//        if (N > K) {
//            System.out.println(N - K);
//            return;
//        }

        bfs(N);

        System.out.println(visited[K]-1);

    }

    private static void bfs(int N) {
        Queue<Integer> q = new LinkedList<>();
        q.add(N);

        visited[N] = 1;

        while (!q.isEmpty()) {
            Integer poll = q.poll();

            int up = poll + 1;
            int down = poll - 1;
            int jump = poll * 2;

            if (jump <= 100000 && visited[jump] == 0) {
                q.add(jump);
                visited[jump] = visited[poll];
            }

            if (down >= 0 && visited[down] == 0) {
                q.add(down);
                visited[down] = visited[poll] + 1;
            }

            if (up <= 100000 && visited[up] == 0) {
                q.add(up);
                visited[up] = visited[poll] + 1;
            }
            
            if (up == K || down == K || jump == K) {
                break;
            }

        }
    }
}

