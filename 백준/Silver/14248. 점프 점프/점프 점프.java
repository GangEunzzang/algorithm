import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    private static int N;
    private static int[] arr;
    private static boolean[] visited;
    private static int visitedCount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = Integer.parseInt(br.readLine());
        visited[start] = true;
        dfs(start);

        System.out.println(visitedCount + 1);

    }

    private static void dfs(int num) {

        int jump = arr[num];
        int left = num - jump;
        int right = num + jump;

        if (left > 0 && !visited[left]) {
            visited[left] = true;
            visitedCount++;
            dfs(left);
        }

        if (right <= N && !visited[right]) {
            visited[right] = true;
            visitedCount++;
            dfs(right);
        }
    }


}
