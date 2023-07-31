
import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int start = 0;
        int end = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            end = Math.max(num, end);
        }

        int M = Integer.parseInt(br.readLine());

        while (start <= end) {
            int mid = (start + end) / 2;
            long budget = IntStream.range(0, N).mapToLong(i -> Math.min(arr[i], mid)).sum();

            if (budget <= M) start = mid + 1;
            else end = mid - 1;
        }

        System.out.println(end);

    }
}