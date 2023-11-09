import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            br.readLine();

            int[] arr1 = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();

            int[] arr2 = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();

            Arrays.sort(arr1);
            Arrays.sort(arr2);

            int N = arr1.length;
            int M = arr2.length;

            int left = 0;
            int right = 0;
            int count = 0;

            while (right < M && left < N) {
                if (arr1[left] <= arr2[right]) {
                    left++;
                } else {
                    count += N - left;
                    right++;
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);

    }

}