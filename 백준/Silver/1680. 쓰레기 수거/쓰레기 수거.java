
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = toInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int W = toInt(st.nextToken()); // 쓰레기차의 용량
            int N = toInt(st.nextToken()); // 지점의 개수

            int[][] data = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                data[i][0] = toInt(st.nextToken()); // 지점의 위치
                data[i][1] = toInt(st.nextToken()); // 쓰레기의 양
            }

            int sumWeight = 0;
            int sumDistance = 0;

            for (int i = 0; i <= N; i++) {
                if (i == N) {
                    if (sumWeight != 0) {
                        sumDistance += data[i - 1][0] * 2;
                    }
                break;
            }

                int curDistance = data[i][0];
                int curWeight = data[i][1];

                // 쓰레기차에 더 실을수 있을 경우
                if (curWeight + sumWeight < W) {
                    sumWeight += curWeight;
                }

                // 쓰레기차의 용량이 가득차 돌아가야 하는 경우
                else if (curWeight + sumWeight == W) {
                    sumWeight = 0;
                    sumDistance += curDistance * 2;
                }

                // 쓰레기차에 더 실을수 없을 경우
                else {
                    sumWeight = curWeight;
                    sumDistance += curDistance * 2;
                }

            }

            sb.append(sumDistance).append("\n");
        }

        System.out.println(sb);
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }
}
