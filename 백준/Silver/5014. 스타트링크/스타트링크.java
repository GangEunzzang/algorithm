import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int G;

    static int U;
    static int D;

    static int[] floor;
    static int[] value;

    static int F;

    static boolean[] visited;

    static int[] going;

    static boolean check;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); // 사무실 총 층수
        int S = Integer.parseInt(st.nextToken()); // 현재 위치
        G = Integer.parseInt(st.nextToken()); // 가고자 하는 위치
        U = Integer.parseInt(st.nextToken()); // 위로 몇칸씩?
        D = Integer.parseInt(st.nextToken()); // 아래로 몇칸씩?

        floor = new int[F + 1];
        value = new int[F + 1];
        visited = new boolean[F + 1];

        going = new int[]{U, -D};


        bfs(S);

        if (check) {
            System.out.println(0);
        } else {
            System.out.println(value[G] == 0 ? "use the stairs" : value[G]);
        }
    }

    static void bfs(int S) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);

        visited[S] = true;
        value[S] = 1;

        if (S == G) {
            check = true;
            return;
        }

        fk:
        while (!queue.isEmpty()) {

            Integer poll = queue.poll();


            for (int i = 0; i < 2; i++) {

                int which = poll + going[i];

                if (which == G) {
                    value[which] = value[poll];
                    break fk;
                }

                if (which > F || which <= 0) {
                    continue;
                }


                if (!visited[which]) {
                    value[which] = value[poll] + 1;
                    queue.add(which);

                    visited[which] = true;
                }


            }


        }

    }

}