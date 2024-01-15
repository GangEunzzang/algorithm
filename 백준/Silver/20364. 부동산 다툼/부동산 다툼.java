import java.io.*;
import java.util.*;


public class Main {

    static int INF = 1_000_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N,Q;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken());
        visited = new boolean[N + 1];

        Q = toInt(st.nextToken());

        while (Q-- > 0) {
            int cur = toInt(br.readLine());
            sb.append(search(cur)).append("\n");
        }

        System.out.println(sb);

    }

    static int search(int cur) {
        int tmp = 0;

        int x = cur;
        while (x != 1) {
            if (visited[x]) tmp = x;
            x >>= 1;
        }

        if (tmp == 0) visited[cur] = true;
        return tmp;
    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }

}




