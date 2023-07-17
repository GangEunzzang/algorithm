import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Double> stack = new Stack<>();

        String s = br.readLine();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int i = 0;

        while (i < s.length()) {
            char check = s.charAt(i++);

            if (check >= 'A' && check <= 'Z') {
                stack.push((double) arr[check - 'A']);
            }

            else {
                Double b = stack.pop();
                Double a = stack.pop();
                
                switch (check) {
                    case '+':
                        stack.add(a + b);
                        break;
                    case '-':
                        stack.add(a - b);
                        break;
                    case '*':
                        stack.add(a * b);
                        break;
                    case '/':
                        stack.add(a / b);
                        break;
                }
            }
        }

        System.out.print(String.format("%.2f", stack.pop()));


    }

}