import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, min = Integer.MAX_VALUE;
    static int[] arr = new int[101];
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken());
        M = toInt(st.nextToken());

        for (int i = 0; i <= 100; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = toInt(st.nextToken());
            int y = toInt(st.nextToken());
            arr[x] = y;
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = toInt(st.nextToken());
            int y = toInt(st.nextToken());
            arr[x] = y;
        }

        bfs();
        System.out.println(min);

    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(1, 0));
        visited[1] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int curX = node.x;
            int count = node.count;

            if (curX == 100) {
                min = Math.min(min, count);
                continue;
            }

            if (arr[curX] != -1) {
                curX = arr[curX];
            }

            for (int i = 1; i <= 6; i++) {
                int mx = curX + i;
                if (mx > 100 || visited[mx]) continue;

                // 뱀과 사다리 위치일때
                if (arr[mx] != mx) {
                    if (!visited[arr[mx]]) {
                        q.add(new Node(arr[mx], count + 1));
                        visited[arr[mx]] = true;
                    }
                } else {
                    visited[mx] = true;
                    q.add(new Node(mx, count + 1));
                }

            }
        }
    }

    static class Node {
        int x;
        int count;

        public Node(int x, int count) {
            this.x = x;
            this.count = count;
        }


    }

    private static int toInt(String s) {
        return Integer.parseInt(s);
    }


}
