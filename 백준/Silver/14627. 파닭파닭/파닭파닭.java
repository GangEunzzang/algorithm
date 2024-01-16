import java.io.*;
import java.util.*;


public class Main {

    static int INF = 1_000_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int S, C;
    static int[] arr;
    static long sum;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        S = toInt(st.nextToken());
        C = toInt(st.nextToken());
        arr = new int[S];

        for (int i = 0; i < S; i++) {
            int num = toInt(br.readLine());
            arr[i] = num;
            sum += num;
        }

        long start = 1;
        long end = 1_000_000_000;
        long mid = (start + end) /2;

        while (start <= end) {
            long count = 0;

            for (int i = 0; i < S; i++) {
                count += arr[i] / mid;
            }

            if (count >= C) start = mid + 1;
            else end = mid - 1;
            mid = (start + end) /2;
        }

        System.out.println(sum - mid * C);

    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }

}




