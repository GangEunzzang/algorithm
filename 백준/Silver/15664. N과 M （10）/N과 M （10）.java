import javax.naming.PartialResultException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    private static int N;
    private static int M;
    private static int[] arr;
    private static int[] numbers;
    private static boolean[] visited;

    private static List<String> list = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        numbers = new int[N];
        visited = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        dfs(0, 0);

        List<String> distinct = list.stream().distinct().collect(Collectors.toList());
        for (String s : distinct) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int depth, int start) {
        if (depth == M) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            list.add(sb.toString());
            sb.setLength(0);
            return;
        }

        for (int i = start; i < N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            arr[depth] = numbers[i];
            dfs(depth + 1, i + 1);
            visited[i] = false;
        }
    }
}
