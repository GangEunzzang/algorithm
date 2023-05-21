import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int idx = 0;

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while (N-- > 0) {
            int targetNumber = Integer.parseInt(br.readLine());

            if (targetNumber > idx) {
                for (int i = idx + 1; i <= targetNumber; i++) {
                    stack.push(i);
                    sb.append("+").append("\n");
                }
                idx = targetNumber;
            } else if (stack.peek() != targetNumber) {
                System.out.println("NO");
                return;
            }

            stack.pop();
            sb.append("-").append("\n");


        }

        System.out.println(sb);
    }
}
