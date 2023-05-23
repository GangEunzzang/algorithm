import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;


        for (int i = 0; i < N; i++) {
            int sum = getSum(arr, arr[i]);

            if (minSum > sum) {
                minSum = sum;
                min = arr[i];
            }
        }

        System.out.println(min);

    }

    private static int getSum(int[] arr, int n) {
        return Arrays.stream(arr).map(j -> Math.abs(j - n)).sum();
    }
}

