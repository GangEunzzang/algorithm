import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N + 1];

        int count = 0;
        int idx = 1;
        int result = 0;

        first:
        while (idx++ <= N) {
            for (int i = idx; i <= N; i += idx) {
                if (visited[i]) continue;
                visited[i] = true;
                if (++count == K) {
                    result = i;
                    break first;
                }
            }
        }

        System.out.println(result);




    }

}