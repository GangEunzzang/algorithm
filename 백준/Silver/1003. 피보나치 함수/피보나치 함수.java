import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {
    private static int[] arr = new int[40 + 1];
    private static Counter[] counters = new Counter[40 + 1];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            counters[0] = new Counter(1, 0);
            counters[1] = new Counter(0, 1);
            counters[2] = new Counter(0, 1);
            counters[3] = new Counter(1, 2);

            fibonaci(N);
            sb.append(counters[N].getZero()).append(" ").append(counters[N].getOne()).append("\n");

            Arrays.fill(arr, 0);
            Arrays.fill(counters, null);

        }

        System.out.println(sb);

    }

    private static int fibonaci(int num) {

        if (num == 0) {
            return 0;
        }

        if (num == 1) {
            return 1;
        }

        if (arr[num] != 0) {
            return arr[num];
        }

        int val = fibonaci(num - 1) + fibonaci(num - 2);

        int zero = counters[num - 1].getZero();
        int zero1 = counters[num - 2].getZero();

        int one = counters[num - 1].getOne();
        int one1 = counters[num - 2].getOne();

        counters[num] = new Counter(zero + zero1, one + one1);

        arr[num] = val;
        return val;

    }

    static class Counter {
        private int zero;
        private int one;

        Counter(int zero, int one) {
            this.zero = zero;
            this.one = one;
        }

        public int getZero() {
            return this.zero;
        }

        public int getOne() {
            return this.one;
        }
    }

}
