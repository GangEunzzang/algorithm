import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        char ch;
        int idx;

        Node(char ch, int idx) {
            this.ch = ch;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[] S = br.readLine().toCharArray();

        Queue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.ch != b.ch) return a.ch - b.ch;
            return a.idx - b.idx;
        });

        // PQ에 모든 문자 삽입
        for (int i = 0; i < N; i++) {
            pq.offer(new Node(S[i], i));
        }

        boolean[] removed = new boolean[N];

        while (M-- > 0) {
            Node cur = pq.poll();
            removed[cur.idx] = true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (!removed[i]) sb.append(S[i]);
        }

        System.out.println(sb);
    }
}
