import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static long[] result = new long[3];
    static long[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long min = Long.MAX_VALUE;

        for (int i = 1; i < N; i++) {

            int start = i;
            int end = N-1;
            int fix = i-1;

            while (start < end) {
                long num = arr[fix] + arr[start] + arr[end];

                if (num == 0) {
                    System.out.println(arr[fix] + " " + arr[start] + " " + arr[end]);
                    return;
                }

                if (Math.abs(num) < Math.abs(min)) {
                    min = num;
                    result[0] = arr[fix];
                    result[1] = arr[start];
                    result[2] = arr[end];
                }

                if (num < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }


}
