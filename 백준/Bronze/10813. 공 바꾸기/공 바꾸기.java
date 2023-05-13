import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int ch1 = Integer.parseInt(st.nextToken());
            int ch2 = Integer.parseInt(st.nextToken());

            int one = arr[ch1];
            int two = arr[ch2];
            
            arr[ch1] = two;
            arr[ch2] = one;

        }

        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
