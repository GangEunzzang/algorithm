import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    private static long[] arr = new long[90 + 1];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Arrays.fill(arr, -1);

        System.out.println(N == 0 ? 0 : fibonaci(N));
    }

    private static long fibonaci(int num) {

        if (num == 1 || num == 2) {
            return 1;
        }

        if (arr[num] != -1) {
            return arr[num];
        }


        long val = fibonaci(num - 1) + fibonaci(num - 2);
        arr[num] = val;

        return val;

    }
}
