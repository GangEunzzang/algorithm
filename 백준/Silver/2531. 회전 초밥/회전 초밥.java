import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 접시 개수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int K = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호
        int[] visited = new int[d + 1];
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;

        for (int i = 0; i < K; i++) {
            visited[arr[i]]++;
            if (visited[arr[i]] == 1) {
                max++;
            }
        }

        int now = max;
        if (visited[c] == 0) {
            max++;
        }

        int left = 0;
        int right = K;

        while (left < N) {
            int del = arr[left++];
            visited[del]--;
            if (visited[del] == 0) {
                now--;
            }

            if (right == N) right = 0;

            int add = arr[right++];
            visited[add]++;
            if (visited[add] == 1) {
                now++;
            }

            max = visited[c] >= 1 ? Math.max(max, now) : Math.max(max, now + 1);

        }

        System.out.println(max);
    }
}