import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] arr;
    static int N;
    static long answer;
    static long curPower;
    static PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        N = toInt(br.readLine()) -1;
        st = new StringTokenizer(br.readLine());
        curPower = toInt(st.nextToken());

        while (N-- > 0) {
            pq.add(Long.parseLong(st.nextToken()));
        }

        while (!pq.isEmpty() && curPower > pq.peek()) {
            curPower += pq.poll();
        }

        System.out.println(pq.isEmpty() ? "Yes" : "No");

    }

    static int toInt(String num) {
        return Integer.parseInt(num);
    }
}
