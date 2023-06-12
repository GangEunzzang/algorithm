import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int N;
    private static int[] aliceArr;
    private static int bobValueMin;
    private static int max;
    private static boolean[] visited;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            aliceArr = new int[N];
            visited = new boolean[N];
            max = 0;

            String bob = br.readLine();
            String alice = br.readLine();
            String reverseOfBob = new StringBuilder(bob).reverse().toString();

            bobValueMin = reverseOfBob.compareTo(bob) > 0 ? Integer.parseInt(bob) : Integer.parseInt(reverseOfBob);

            for (int i = 0; i < N; i++) {
                aliceArr[i] = alice.charAt(i) - '0';
            }

            dfs(0,  0);
            sb.append(max).append("\n");

        }

        System.out.println(sb);

    }

    private static void dfs(int idx, int num) {
        if (num < bobValueMin && num > max) max = num;
        if (idx == N) return;

        for (int i = 0; i < N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            dfs(idx + 1, num * 10 + aliceArr[i]);
            visited[i] = false;
        }
    }
}