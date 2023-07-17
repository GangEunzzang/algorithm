import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            String check = br.readLine();

            if ("0".equals(check)) {
                sb.append(pq.isEmpty() ? -1 : pq.poll()).append("\n");
            }
            else {
                StringTokenizer st = new StringTokenizer(check, " ");
                int giftCount = Integer.parseInt(st.nextToken());

                while (giftCount --> 0)
                    pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(sb);

    }

}