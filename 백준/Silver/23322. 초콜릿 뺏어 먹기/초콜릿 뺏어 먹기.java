import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int K;
    private static int[] arr;
    private static int sum;
    private static int day;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] =  Integer.parseInt(st.nextToken());
        }

        solve();

        System.out.println(sum + " " + day);

    }

    private static void solve() {

        int idx = K + 1;

        while (idx <= N) {

            if (arr[idx] > arr[idx - K]) {
                sum += arr[idx] - arr[idx - K];
                arr[idx] = arr[idx-K];
                day++;
                Arrays.sort(arr);
            } else {
                idx++;
            }
        }
    }

}
