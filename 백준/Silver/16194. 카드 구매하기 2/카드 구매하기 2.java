import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int d[];
    private static int arr[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        d = new int[N + 1];
        arr = new int[N + 1];


        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= N; i++) {
            d[i] = arr[i];
            for (int j = 1; j <= i; j++) {
                d[i] = Math.min(d[i], d[i - j] + arr[j]);
            }
        }

        System.out.println(d[N]);
    }

}