import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs();
    }

    private static void dfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(N, String.valueOf(N), 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            int num = node.num;
            String course = node.course;
            int count = node.count;

            if (num == 1) {
                System.out.println(count);
                System.out.println(course);
                return;
            }

            if (num % 3 == 0) {
                q.add(new Node(num / 3, course + " " + (num / 3), count + 1));
            }

            if (num % 2 == 0) {
                q.add(new Node(num / 2, course +  " " + (num / 2), count + 1));
            }

            q.add(new Node(num - 1, course +  " " + (num - 1), count + 1));


        }
    }

    static class Node {
        private int num;
        private String course;

        private int count;

        public Node(int num, String course, int count) {
            this.num = num;
            this.course = course;
            this.count = count;
        }
    }

}