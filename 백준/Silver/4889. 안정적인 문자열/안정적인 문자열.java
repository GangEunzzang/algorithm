import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int idx = 1;

        while (true) {
            String s = br.readLine();
            if (s.contains("-")) {
                break;
            }

            Stack<Character> stack = new Stack<>();
            int changeCount = 0;

            for (int i = 0; i < s.length(); i++) {
                char cur = s.charAt(i);
                if (cur == '{') {
                    stack.push('{');
                    continue;
                }

                if (stack.isEmpty()) {
                    stack.add('{');
                    changeCount++;
                } else {
                    stack.pop();
                }
            }

            if (!stack.isEmpty()) {
                changeCount += Math.max(stack.size() / 2, 1);
            }

            sb.append(idx++)
                    .append(". ")
                    .append(changeCount)
                    .append("\n");
            }

        System.out.println(sb);
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }
}
