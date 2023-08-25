import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    private static int N;
    private static int[] arr;
    private static int[] operator = new int[4];
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    private static char[] cal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        cal = new char[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) operator[i] = Integer.parseInt(st.nextToken());

        dfs(0);

        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int depth) {

        if (depth == N - 1) {
            calculateResult();
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] == 0) continue;

            cal[depth] = getOperatorBySeq(i);

            operator[i]--;
            dfs(depth + 1);
            operator[i]++;
        }
    }

    private static void calculateResult() {

        Deque<Integer> numStack = new LinkedList<>();
        Deque<Character> operatorStack = new LinkedList<>();
        numStack.add(arr[0]);

        for (int i = 0; i < cal.length; i++) {
            char operator = cal[i];

            switch (operator) {
                case '+': case '-' :
                    operatorStack.addLast(operator);
                    numStack.addLast(arr[i + 1]);
                    break;
                case '*':
                    numStack.addLast(numStack.pollLast() * arr[i + 1]);
                    break;
                case '/':
                    numStack.addLast(numStack.pollLast() / arr[i + 1]);
                    break;
            }
        }

        int result = numStack.poll();
        
        while (!operatorStack.isEmpty()) {
            Character operator = operatorStack.poll();

            Integer num = numStack.poll();

            if (operator == '+') result += num;
            if (operator == '-') result -= num;
        }


        max = Math.max(result, max);
        min = Math.min(result, min);

    }


    private static char getOperatorBySeq(int i) {

        if (i == 0) return '+';
        if (i == 1) return '-';
        if (i == 2) return '*';
        if (i == 3) return '/';

        throw new RuntimeException("잘못된 요청");
    }
}
