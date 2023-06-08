import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[] S;
    private static int[] B;

    private static boolean[] visited;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new int[N];
        B = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0,1,0);
        System.out.println(min);
    }

    private static void dfs(int index, int count, int s, int b) {
        if (index > 0) 
            min = Math.min(min, Math.abs(s - b));
        
        for (int i = count; i < N ; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            dfs(index + 1, i, s * S[i], b + B[i]);
            visited[i] = false;
        }
    }

}
