import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        int max = 0;


        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(br.readLine());
            max = Math.max(num, max);
            arr[i] = num;
        }

        List<Integer> fibonacciList = new ArrayList<>();
        fibonacciList.add(1);
        fibonacciList.add(1);

        int idx = 2;
        while (true) {
            int num = fibonacciList.get(idx - 2) + fibonacciList.get(idx - 1);
            if (num > max) {
                break;
            }
            idx++;
            fibonacciList.add(num);
        }


        for (int i = 0; i < T; i++) {

            StringBuilder smallSb = new StringBuilder();
            Stack<Integer> stack = new Stack<>();

            int testNum = arr[i];

            for (int j = fibonacciList.size() - 1; j >= 0; j--) {
                Integer fibonacci = fibonacciList.get(j);
                if (fibonacci > testNum) continue;

                testNum -= fibonacci;
                stack.add(fibonacci);
            }
            
            while (!stack.isEmpty()) {
                smallSb.append(stack.pop() + " ");
            }

            sb.append(smallSb + "\n");
        }


        System.out.println(sb);

    }
}
