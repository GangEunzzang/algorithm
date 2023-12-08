import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, min = Integer.MAX_VALUE;
    static int[] arr, result;

    public static void main(String[] args) throws IOException {
        N = toInt(br.readLine());
        arr = new int[N];
        result = new int[2];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = toInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = N-1;

        while (start < end) {
            int val = arr[start] + arr[end];

            if (Math.abs(val) < Math.abs(min)) {
                result[0] = arr[start];
                result[1] = arr[end];
                min = val;
            }

            if (val < 0) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(result[0] + " " + result[1]);


    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}
