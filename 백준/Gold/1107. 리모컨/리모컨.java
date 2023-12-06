import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static boolean[] breakdown = new boolean[10];
    static int N, result, min;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        if (M != 0) st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            breakdown[Integer.parseInt(st.nextToken())] = true;
        }

        result = Math.abs(N - 100);

        first:
        for (int i = 0; i < 999999; i++) {
            String num = String.valueOf(i);

            for (int j = 0; j < num.length(); j++) {
                if (breakdown[num.charAt(j) - '0']) continue first;
            }

            result = Math.min(result, Math.abs(N - i) + num.length());
        }

        System.out.println(result);

    }


}
