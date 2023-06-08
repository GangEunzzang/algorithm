import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int M;
    private static int N;
    private static int[] arr;

    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        solve();
        System.out.println(result);
    }

    private static void solve() {

        int start = 1;
        int end = arr[N - 1];

        while (start <= end) {

            int count = 0;
            int mid = (end + start) / 2;

            for (int i = 0; i < N; i++) {
                if(count >= M) break;
                count += arr[i] / mid;
            }

            if (count >= M){
                result = Math.max(result, mid);
                start = mid + 1;
            }

            if (count < M) end = mid - 1;

        }

    }

}
