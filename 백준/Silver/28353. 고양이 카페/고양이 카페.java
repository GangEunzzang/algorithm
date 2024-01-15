import java.io.*;
import java.util.*;


public class Main {

    static int INF = 1_000_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N,K, result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken());
        K = toInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = toInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = N-1;
        while (start < end) {
            if (arr[start] + arr[end] <= K) {
                start++;
                end--;
                result++;
            } else {
                end--;
            }
        }

        System.out.println(result);
    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }

}




