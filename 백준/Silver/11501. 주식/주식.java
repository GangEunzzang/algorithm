import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[j] = num;
            }
            sb.append(results(arr)).append("\n");
        }
        System.out.println(sb);
    }

    public static long results(int[] arr) {
        long sum = 0;
        long max = 0;

        for (int i = arr.length - 1; i >= 0; i--) {

            if (arr[i] > max) {
                max = arr[i];
            } else {

                sum += max - arr[i];
            }
        }
        return sum;
    }

}
