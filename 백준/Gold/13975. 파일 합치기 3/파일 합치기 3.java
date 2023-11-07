import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Long> pq;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            pq = new PriorityQueue<>();
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (N-- > 0) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            long result = 0;

            while (pq.size() >= 2) {
                long sum = pq.poll() + pq.poll();
                result += sum;
                pq.add(sum);
            }

            sb.append(result).append("\n");
        }

        System.out.println(sb);

    }
}