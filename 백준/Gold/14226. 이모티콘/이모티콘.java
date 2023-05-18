import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int S;
    private static boolean[][] visited = new boolean[1001][1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        bfs();
    }

    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 0, 0));

        visited[1][0] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int length = node.length;
            int time = node.time;
            int clipboard = node.clipboard;

            if (length == S) {
                System.out.println(time);
                return;
            }

            q.add(new Node(length, length, time + 1));

            if (clipboard != 0 && length + clipboard <= S && !visited[length + clipboard][clipboard]) {
                q.add(new Node(length + clipboard, clipboard, time + 1));
                visited[length + clipboard][clipboard] = true;
            }

            if (length >= 1 && !visited[length-1][clipboard]) {
                q.add(new Node(length - 1, clipboard, time + 1));
                visited[length -1][clipboard] = true;
            }

        }
    }

    private static class Node {
        int length;
        int clipboard;
        int time;

        public Node(int length, int clipboard, int time) {
            this.length = length;
            this.clipboard = clipboard;
            this.time = time;
        }
    }


}

