import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static Deque<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int num = 0;
        for (int i = 0; i < N; i++ ) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push_front" :
                    pushFront(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back" :
                    pushBack(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    popFront();
                    break;
                case "pop_back":
                    popBack();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    empty();
                    break;
                case "front":
                    front();
                    break;
                case "back":
                    back();
                    break;
            }
        }

        System.out.println(sb);
    }


    public static void pushFront(int num) {
        queue.offerFirst(num);
    }

    public static void pushBack(int num) {
        queue.offerLast(num);
    }

    public static void popFront() {
        if (queue.isEmpty()) {
            sb.append("-1").append("\n");
        } else {
            sb.append(queue.pollFirst()).append("\n");
        }
    }

    public static void popBack() {
        if (queue.isEmpty()) {
            sb.append("-1").append("\n");
        } else {
            sb.append(queue.pollLast()).append("\n");
        }
    }

    public static void size() {
        sb.append(queue.size()).append("\n");
    }

    public static void empty() {
        if (queue.isEmpty()) {
            sb.append("1").append("\n");
        } else {
            sb.append("0").append("\n");
        }
    }

    public static void front() {
        if (queue.isEmpty()) {
            sb.append("-1").append("\n");
        } else {
            sb.append(queue.peekFirst()).append("\n");
        }
    }

    public static void back() {
        if (queue.isEmpty()) {
            sb.append("-1").append("\n");
        } else {
            sb.append(queue.peekLast()).append("\n");
        }
    }
}
