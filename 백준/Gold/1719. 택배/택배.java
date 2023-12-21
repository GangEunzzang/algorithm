import java.io.*;
import java.util.*;


public class Main {

    static int INF = 100_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[][] arr;
    static int[][] answer;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken());
        M = toInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        answer = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(arr[i], INF);
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = toInt(st.nextToken());
            int from = toInt(st.nextToken());
            int cost = toInt(st.nextToken());

            arr[from][to] = cost;
            arr[to][from] = cost;

            answer[from][to] = to;
            answer[to][from] = from;
        }


        // k = 중간
        // i = 시작
        // j = 도착
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                        answer[i][j] = answer[i][k];
                    }
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                sb.append(i == j ? "- " : answer[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}

