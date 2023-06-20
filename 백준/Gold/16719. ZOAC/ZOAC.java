import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    private static String s;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        s = new Scanner(System.in).next();
        int repeat = s.length();
        sb.append(s);

        PriorityQueue<StringBuilder> pq;

        while (--repeat > 0) {
            pq = new PriorityQueue<>();

            for (int i = 0; i < s.length(); i++) {
                pq.add(new StringBuilder(s).deleteCharAt(i));
            }

            StringBuilder poll = pq.poll();
            s = poll.toString();
            sb.insert(0, poll + "\n");

        }

        System.out.println(sb);

    }

}
