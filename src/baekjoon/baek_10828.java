package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class baek_10828 {

    static Stack stack = new Stack();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push":
                    push((Integer.parseInt(st.nextToken())));
                    break;

                case "pop":
                    pop();
                    break;

                case "size":
                    size();
                    break;

                case "empty":
                    empty();
                    break;

                case "top":
                    top();
                    break;
            }
        }

        System.out.println(sb);
    }

    public static void push(int num) {
        stack.push(num);
    }

    public static void pop() {
        if (stack.empty()) {
            sb.append("-1").append("\n");
        }

        if (!stack.empty()) {
            sb.append(stack.peek()).append("\n");
            stack.pop();
        }
    }

    public static void top() {
        if (stack.empty()) {
            sb.append("-1").append("\n");
        }

        if (!stack.empty()) {
            sb.append(stack.peek()).append("\n");
        }
    }

    public static void size() {
        sb.append(stack.size()).append("\n");
    }

    public static void empty() {
        boolean empty = stack.empty();
        if (empty) {
            sb.append("1").append("\n");
        }

        if (!empty) {
            sb.append("0").append("\n");
        }
    }




}
