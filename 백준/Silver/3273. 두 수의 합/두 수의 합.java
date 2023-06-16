import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int[] arr;
    private static int x;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();
        System.out.println(count);

    }

    private static void solve() {
        Arrays.sort(arr);
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int sum = arr[start] + arr[end];

            if (sum == x){
                end--;
                start ++;
                count ++;
            }

            if (sum < x) start++;
            if (sum > x) end --;
        }
    }
}
