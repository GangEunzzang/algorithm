import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        first:
        while (T-- > 0) {
            int order = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int targetIdx = Integer.parseInt(st.nextToken());

            Queue<Node> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                q.add(new Node(i, Integer.parseInt(st.nextToken())));
            }


            while (!q.isEmpty()) {

                Node node = q.peek();

                if (checkPriority(node.priority, q)) {
                    q.add(q.poll());
                    continue;
                }

                Node poll = q.poll();
                if (poll.idx == targetIdx) {
                    sb.append(order).append("\n");
                    continue first;
                }

                order++;
            }
        }
        System.out.println(sb);
    }

    static class Node {
        public int idx;
        public int priority;

        public Node(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }

    }

    static boolean checkPriority(int priority, Queue<Node> q) {
        return q.stream().anyMatch(item -> item.priority > priority);
    }

}