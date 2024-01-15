import java.io.*;
import java.util.*;


public class Main {

    static int INF = 1_000_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            q.add(toInt(st.nextToken()));
        }

        Stack<Integer> stack = new Stack<>();
        int target = 1;

        while (!q.isEmpty()) {
            while (!stack.isEmpty() && stack.peek() == target) {
                stack.pop();
                target++;
            }

            Integer cur = q.poll();
            if (cur != target) stack.add(cur);
            else target++;
        }

        while (!stack.isEmpty() && stack.peek() == target) {
            stack.pop();
            target++;
        }

        System.out.println(stack.isEmpty() ? "Nice" : "Sad");
    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }

}




