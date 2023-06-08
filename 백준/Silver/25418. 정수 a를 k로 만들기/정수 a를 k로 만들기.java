import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int A;
    private static int K;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[1_000_001];
        solve();

    }

    private static void solve() {

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(A, 0));
        visited[A] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int val = node.val;
            int count = node.count;

            if (val == K) {
                System.out.println(count);
                return;
            }

            if (val * 2 <= 1_000_000 && !visited[val * 2]) {
                q.add(new Node(val * 2, count + 1));
                visited[val * 2] = true;
            }

            if (val + 1 <= 1_000_000 && !visited[val + 1]) {
                q.add(new Node(val + 1, count + 1));
                visited[val + 1] = true;
            }

        }
    }

    static class Node {
        int val;
        int count;

        Node(int val, int count) {
            this.val = val;
            this.count = count;
        }
    }


}
