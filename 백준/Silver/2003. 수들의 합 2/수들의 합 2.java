import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        int sum = 0;
        int j = 0;

        for (int i = 0; i < N; i++) {
            while (j < N && sum + arr[j] <= M) {
                sum += arr[j];
                j++;
            }

            if (sum == M) {
                count++;
            }

            sum -= arr[i];
        }

        System.out.println(count);
    }
}
