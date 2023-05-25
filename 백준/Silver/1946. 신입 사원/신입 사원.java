import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine()); // 지원자의 숫자
            int[] arr = new int[N + 1];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                arr[score] = Integer.parseInt(st.nextToken());
            }

            int count = 1;
            int min = arr[1];

            for (int i = 2; i <= N; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    count++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);

    }
}

