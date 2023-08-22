import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;

        for (int i = N - 1; i >= 1; i--) {
            if (arr[i] <= arr[i - 1]) {
                int val = arr[i - 1] - arr[i] + 1;
                result += val;

                arr[i - 1] = arr[i] - 1;
            }
        }

        System.out.println(result);

    }


}
