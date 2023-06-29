import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        PriorityQueue<Character> pq = new PriorityQueue<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        for (int i = 0; i < s1.length(); i++) {
            pq.add(s1.charAt(i));
        }

        for (int i = 0; i < s2.length(); i++) {
            pq.add(s2.charAt(i));
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) sb.append(pq.poll());

        System.out.println(sb);

    }

}