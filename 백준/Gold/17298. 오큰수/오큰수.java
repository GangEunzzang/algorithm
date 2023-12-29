import java.io.*;
import java.util.*;


public class Main {

    static int INF = 1_000_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        N = toInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = toInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            if (stack.isEmpty()) {
                stack.add(i);
                continue;
            }

            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i];
            }

            stack.add(i);
        }

        while (!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }

    static int toInt(String val) {
        return Integer.parseInt(val);
    }

}




