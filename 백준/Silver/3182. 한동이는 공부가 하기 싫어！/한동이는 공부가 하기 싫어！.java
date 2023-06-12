import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N;
    private static int[] arr;
    private static boolean[] visited;
    private static int max;
    private static int nowMax;
    private static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i, 0);

            if(nowMax > max ){
                max = nowMax;
                answer = i;
            }

            nowMax = 0;

        }

        System.out.println(answer);

    }

    private static void dfs(int idx, int count) {
        nowMax = Math.max(count, nowMax);

        if (!visited[idx]) {
            visited[idx] = true;
            dfs(arr[idx], ++count);
        }

    }

}