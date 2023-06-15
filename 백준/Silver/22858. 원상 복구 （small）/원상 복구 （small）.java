import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int[] change;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        change = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            change[i] = Integer.parseInt(st2.nextToken());
        }

        while (K-- > 0) {
            shuffle();
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
        };

    }

    private static void shuffle() {
        int[] temp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            temp[change[i]] = arr[i]; 
        }

        arr = temp;
    }


}
