import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N <= 3) {
            System.out.println(1);
            return;
        }

        long[] fibonacci = new long[N + 1];

        fibonacci[1] = 1;
        fibonacci[2] = 1;
        fibonacci[3] = 1;

        for (int i = 4; i <= N; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 3];
        }

        System.out.println(fibonacci[N]);



    }
}