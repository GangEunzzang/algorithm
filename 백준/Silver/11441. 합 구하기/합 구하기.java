import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int N, max;

    public static void main(String[] args) throws IOException {
        N = toInt(br.readLine());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + toInt(st.nextToken());
        }

        int M = toInt(br.readLine());
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int i = toInt(st.nextToken());
            int j = toInt(st.nextToken());

            sb.append(arr[j] - arr[i-1]).append("\n");
        }

        System.out.println(sb);


    }

    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}
