import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) * 2;
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N / 2; i++) {

            int first = arr[i + 1];
            int end = arr[N-i];

            if (first + end < min) {
                min = first + end;
            }
        }

        System.out.println(min);
    }
}
