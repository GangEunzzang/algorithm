import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    private static StringBuilder sb = new StringBuilder();
    private static Deque<Character> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            int T = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < T; j++) {
                String s = st.nextToken();
                Character val = s.charAt(0);
                if (!q.isEmpty()) {
                    Character peek = q.peek();
                    if (peek >= val) {
                        q.offerFirst(val);
                    } else {
                        q.offer(val);
                    }
                } else {
                    q.offer(val);
                }
            }

            while (!q.isEmpty()) {
                sb.append(q.poll());
            }
            sb.append("\n");
        };

        System.out.println(sb);
    }
}
