import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static int N; // 문제의 개수
    private static int L; // 얘보다 크거나 같고
    private static int R; // 얘보다 작거나 같고
    private static int X; // 가장 어려운문제와 가장 쉬운문제의 난이도 차이는 얘보다 커야함

    private static int[] arr;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, 0,0,Integer.MIN_VALUE, Integer.MAX_VALUE);

        System.out.println(answer);
    }

    private static void dfs(int depth, int cnt, int sum, int max, int min) {

        if (cnt >= 2) {
            if (sum >= L && sum <= R && max - min >= X) {
                answer++;
            }
        }

        for (int i = depth; i < N; i++) {
            dfs(i + 1, cnt + 1, sum + arr[i], Math.max(max, arr[i]), Math.min(min, arr[i]));
        }
    }

}