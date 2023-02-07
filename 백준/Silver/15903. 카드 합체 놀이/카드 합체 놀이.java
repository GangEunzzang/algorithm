import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static PriorityQueue<Long> queue = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            queue.add((Long.parseLong(st.nextToken())));
        }



        for (int i = 0; i < M; i++) {
            long add = queue.poll() + queue.poll();
            queue.add(add);
            queue.add(add);
        }

        System.out.println(queue.stream().reduce(0L, Long::sum));

    }

}
