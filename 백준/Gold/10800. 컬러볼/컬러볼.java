import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        List<Ball> balls = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken())-1;
            int size = Integer.parseInt(st.nextToken());
            balls.add(new Ball(i, color, size));
        }

        Collections.sort(balls, Comparator.comparingInt(o -> o.size));

        int sum = 0;

        int[] colorSum = new int[N];
        int[] result = new int[N];

        int sizeCheckIdx = 0;

        for (Ball ball : balls) {
            Ball checkBall = balls.get(sizeCheckIdx);
            int curSize = ball.size;

            while (checkBall.size < curSize) {
                colorSum[checkBall.color] += checkBall.size;
                sum += checkBall.size;
                checkBall = balls.get(++sizeCheckIdx);
            }

            result[ball.idx] = sum - colorSum[ball.color];
        }

        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);
    }


    static class Ball {
        int idx;
        int color;
        int size;

        public Ball(int idx, int color, int size) {
            this.idx = idx;
            this.color = color;
            this.size = size;
        }
    }
}
