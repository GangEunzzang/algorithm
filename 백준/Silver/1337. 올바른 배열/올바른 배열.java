import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = 0;
        int result = 4;

        while (right < N) {
            int diff = arr[right] - arr[left];

            if (diff < 5) {
                right++;
                result = Math.min(result, 5 - (right-left));
            }

            if (diff >= 5) {
                left++;
            }
        }

        System.out.println(result);

    }

}