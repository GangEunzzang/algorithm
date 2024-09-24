import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int N = toInt(br.readLine());
        Integer[] arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = toInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int result = -1;
        for (int i = 0; i < N - 2; i++) {
            if (arr[i] < arr[i + 1] + arr[i + 2]) {
                result = arr[i] + arr[i+1] + arr[i+2];
                break;
            }
        }

        System.out.println(result);
    }

    private static int toInt(String val) {
        return Integer.parseInt(val);
    }

}
