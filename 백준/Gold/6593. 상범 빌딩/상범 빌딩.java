import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    private static int L, R, C;
    private static int startL, startR, startC;
    private static char[][][] arr;
    private static boolean[][][] visited;
    private static int minMinute;
    private static int[] moveL = {-1, 1, 0, 0, 0, 0};
    private static int[] moveR = {0, 0, -1, 1, 0, 0};
    private static int[] moveC = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            minMinute = Integer.MAX_VALUE;
            arr = new char[R][C][L];
            visited = new boolean[R][C][L];


            // 1 가능  0 불가능
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String s = br.readLine();
                    for (int k = 0; k < C; k++) {
                        char check = s.charAt(k);

                        if (check == 'S') {
                            startL = i;
                            startR = j;
                            startC = k;
                        }

                        arr[j][k][i] = check;
                    }
                }
                br.readLine();
            }

            bfs();
            sb.append(minMinute == Integer.MAX_VALUE ? "Trapped! \n" : "Escaped in " + minMinute + " minute(s).\n");
        }

        System.out.println(sb);
    }


    private static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startL, startR, startC,0));
        visited[startR][startC][startL] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (arr[node.r][node.c][node.l] == 'E') {
                minMinute = Math.min(minMinute, node.count);
                return;
            }

            for (int i = 0; i < 6; i++) {
                int ml = node.l + moveL[i];
                int mr = node.r + moveR[i];
                int mc = node.c + moveC[i];

                if (ml < 0 || mr < 0 || mc < 0 || ml >= L || mr >= R || mc >= C) continue;
                if (visited[mr][mc][ml] || arr[mr][mc][ml] == '#') continue;

                visited[mr][mc][ml] = true;
                q.add(new Node(ml, mr, mc, node.count + 1));
            }
        }
    }


    private static class Node {
        int l;
        int r;
        int c;
        int count;

        public Node(int l, int r, int c, int count) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.count = count;
        }
    }
}