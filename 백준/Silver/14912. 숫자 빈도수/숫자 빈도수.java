import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int result = 0;
        for (int i = 1; i <= n; i++) {

            for (char c : String.valueOf(i).toCharArray()) {
                if (c - '0' == d) result++;
            }
        }

        System.out.println(result);
    }
}


