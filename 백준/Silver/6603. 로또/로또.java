import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] arr;
    private static boolean[] visited;
    private static int[] answer;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            if(N == 0) break;

            arr = new int[N];
            visited = new boolean[N];
            answer = new int[6];

            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }


            dfs(0, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int idx, int start) {

        if(answer[0] > arr[N - 6]) return;

        if (idx == 6) {
            for (int i = 0; i < 6; i++) {
                sb.append(answer[i] + " ");
            }
            sb.append("\n");
            return;
        }


        for (int i = start; i < N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            answer[idx] = arr[i];
            dfs(idx + 1, i);
            visited[i] = false;
        }

    }
}