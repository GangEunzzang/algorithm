import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        // 1 2 4 8 9
        // 9 8 4 2 1

        int sum = 0;
        int mid = 0;

        if (N == 1) {
            System.out.println(arr[0]);
            return;
        }

        if (N % 2 == 0) {
            for (int i = 0; i < N/2; i++) {
                sum += arr[N-i-1] * 2;
            }
        } else {
            for (int i = 0; i < N/2; i++) {
                sum += arr[N-i-1] * 2;
            }
            sum += arr[(N-1) /2];
        }


        System.out.println(sum);

    }
}
