import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 양동이 개수
        int K = Integer.parseInt(st.nextToken()) *2 +1; // 양동이 잡을 수 있는 간격

        int[] arr = new int[1_000_001];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken()); // 얼음 개수
            int x = Integer.parseInt(st.nextToken()); // 위치
            arr[x] = g;
        }

        int max = 0, now = 0;

        for (int i = 0; i <= 1_000_000; i++) {
            if(i-K>=0) {
                now -= arr[i - K];
            }

            now += arr[i];
            max = Math.max(now, max);
        }

        System.out.println(max);
    }
}


