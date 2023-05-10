import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int K;
    private static int min = Integer.MAX_VALUE;
    private static int minCount;

    private static boolean[] visited = new boolean[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N > K) {
            System.out.println(N - K);
            System.out.println(1);
            return;
        }
        bfs();
        System.out.println(min);
        System.out.println(minCount);
    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0));

        while (!queue.isEmpty()){

            Node node = queue.poll();

            visited[node.num] = true;

            if (node.num > K) {
                node.time += node.num - K;
                node.num = K;
            }

            if (node.time > min) {
                continue;
            }

            if (node.num == K) {
                if (min == node.time) {
                    minCount++;
                } else {
                    min = node.time;
                    minCount = 1;
                }
                continue;
            }


            if (node.num - 1 >= 0 && !visited[node.num - 1]) {
                queue.add(new Node(node.num - 1, node.time + 1));
            }

            if (node.num + 1 <= 100_000 && !visited[node.num + 1]) {
                queue.add(new Node(node.num + 1, node.time + 1));
            }

            if (node.num * 2 <= 100_000 && !visited[node.num * 2]) {
                queue.add(new Node(node.num * 2, node.time + 1));
            }
            
        }
    }

    static class Node {
        int time;
        int num;

        public Node(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }


}