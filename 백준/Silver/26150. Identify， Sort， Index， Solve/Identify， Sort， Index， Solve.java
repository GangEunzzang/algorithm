import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o.idx));

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String S = st.nextToken().toUpperCase();
            int idx = Integer.parseInt(st.nextToken());

            priorityQueue.add(new Node(idx, S.charAt(Integer.parseInt(st.nextToken()) -1)));
        }

        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            sb.append(priorityQueue.poll().c);
        }

        System.out.println(sb);

    }


    static class Node {
        int idx;
        char c;

        Node(int idx, char c) {
            this.idx = idx;
            this.c = c;
        }
    }

}