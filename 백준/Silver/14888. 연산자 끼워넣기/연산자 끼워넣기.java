import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int[] operator = new int[4];

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, arr[0]);
        System.out.println(max);
        System.out.println(min);

    }

    static void dfs(int idx, int sum) {
        if (idx == N) {
            min = Math.min(sum, min);
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] == 0) continue;
            operator[i] --;

            switch (i) {
                case 0: dfs(idx + 1, sum + arr[idx]); break;
                case 1: dfs(idx + 1, sum - arr[idx]); break;
                case 2: dfs(idx + 1, sum * arr[idx]); break;
                case 3: dfs(idx + 1, sum / arr[idx]); break;
            }
            operator[i]++;
        }
    }


}