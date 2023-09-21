import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);

        int[] balls = new int[K];

        int nowBallCount = 0;

        for (int i = 0; i < K; i++) {
            balls[i] = i + 1;
            nowBallCount += i + 1;
        }

        if (nowBallCount > N) {
            System.out.println(-1);
            return;
        }

        N -= nowBallCount;

        int idx = K - 1;

        while (N-- > 0) {
            balls[idx]++;

            idx--;
            if (idx == -1) idx = K - 1;
        }
        for (int i = balls.length - 1; i >= 0; i--) {
            if (N-- < 1) break;
            balls[i]++;
        }

        System.out.println(balls[K-1] - balls[0]);
    }
}
