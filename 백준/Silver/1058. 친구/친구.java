import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[][] arr;
    static boolean[] visited;
    static int N, max;

    public static void main(String[] args) throws IOException {
        N = toInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j) == 'N' ? 0 : 1;
            }
        }

        for (int i = 0; i < N; i++) {
            max = Math.max(bfs(i), max);
        }

        System.out.println(max);

    }

    static int bfs(int x) {
        visited = new boolean[N];

        int count = 0;
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            if (i != x && arr[x][i] == 1){
                count++;
                visited[i] = true;
                q.add(i);
            }

        }

        while (!q.isEmpty()) {
            Integer num = q.poll();
            for (int i = 0; i < N ; i++) {
                if (i != x && arr[num][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    count++;
                }
            }
        }
        return count;

    }

    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}
