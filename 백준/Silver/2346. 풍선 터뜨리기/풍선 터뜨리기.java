import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Node> dq = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            dq.add(new Node(i, Integer.parseInt(st.nextToken())));
        }

        int order = 0;
        while (dq.size() > 1) {

            Node node = (order >= 0) ? dq.pollFirst() : dq.pollLast();

            for (int i = 0; i < Math.abs(node.order) - 1; i++) {
                if (node.order > 0) {
                    dq.addLast(dq.pollFirst());
                } else {
                    dq.addFirst(dq.pollLast());
                }
            }
            order = node.order;
            sb.append(node.idx).append(" ");
        }

        sb.append(Objects.requireNonNull(dq.poll()).idx);
        System.out.println(sb);
    }
}
 class Node {

    public Node(int idx, int order) {
        this.idx = idx;
        this.order = order;
    }

    int idx;
    int order;
}


