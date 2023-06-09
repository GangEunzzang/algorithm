import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static int[] arr;
    private static int max = Integer.MIN_VALUE;
    private static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            max = Math.max(max, num);
            arr[i] = num;
        }

        solve();
        System.out.println(result);

    }
    private static void solve() {

        int start = max;
        int end = 10_000 * 100_000;

        while (start <= end) {

            int mid = (start + end) / 2;
            int check = isCheck(mid);

            if (M >= check) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
    }

    private static int isCheck(int number) {

        int changes = number;
        int count = 1;

        for (int i : arr) {
            changes -= i;

            if(changes < 0) {
                count++;
                changes = number - i;
            }
        }

        return count;
    }

}
