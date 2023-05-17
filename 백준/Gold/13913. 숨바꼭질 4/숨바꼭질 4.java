import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int K;
    private static int[] visited = new int[100_001];

    private static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());


        if (N == K) {
            System.out.println(0);
            System.out.println(K);
            return;
        }

        if (N > K) {
            System.out.println(N - K);

            for (int i = N; i >= K; i--) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }



        bfs(N);

        System.out.println(visited[K]-1);
        for (Integer integer : list) {
            sb.append(integer).append(" ");
        }
        System.out.println(sb);

    }

    private static void bfs(int N) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, List.of(N)));

        visited[N] = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();

            int point = node.point;
            List<Integer> nodeList = node.list;

            int up = point + 1;
            int down = point - 1;
            int jump = point * 2;

            if (jump <= 100000 && visited[jump] == 0) {
                List<Integer> jumpList = new ArrayList<>(nodeList);
                jumpList.add(jump);

                q.add(new Node(jump, jumpList));
                visited[jump] = visited[point] + 1;

                if (jump == K) {
                    list = jumpList;
                    break;
                }
            }

            if (up <= 100000 && visited[up] == 0) {
                List<Integer> upList = new ArrayList<>(nodeList);
                upList.add(up);

                q.add(new Node(up, upList));
                visited[up] = visited[point] + 1;

                if (up == K) {
                    list = upList;
                    break;
                }
            }


            if (down >= 0 && visited[down] == 0) {
                List<Integer> downList = new ArrayList<>(nodeList);
                downList.add(down);

                q.add(new Node(down, downList));
                visited[down] = visited[point] + 1;

                if (down == K) {
                    list = downList;
                    break;
                }
            }
        }
    }

    static class Node {
        int point;
        List<Integer> list;
        public Node(int nowPoint, List<Integer> list) {
            this.point = nowPoint;
            this.list = list;
        }

    }

}

