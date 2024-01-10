import java.io.*;
import java.util.*;


public class Main {

    static int INF = 1_000_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int T, N;

    public static void main(String[] args) throws IOException {
        T = toInt(br.readLine());

        while (T-- > 0) {
            N = toInt(br.readLine());
            int max = 0;
            int idx = 0;
            int count = 0;
            int sum = 0;

            for (int i = 0; i < N; i++) {
                int num = toInt(br.readLine());
                sum += num;

                if (num == max) {
                    count++;
                    continue;
                }

                if (num > max) {
                    max = num;
                    count = 1;
                    idx = i + 1;
                }
            }

            if (count > 1) sb.append("no winner");
            else if (max > sum / 2) sb.append("majority winner " + idx);
            else if (max <= sum / 2) sb.append("minority winner " + idx);
            sb.append("\n");
        }

        System.out.println(sb);
    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }

}




