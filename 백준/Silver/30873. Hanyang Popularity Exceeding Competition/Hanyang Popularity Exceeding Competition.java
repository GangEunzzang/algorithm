import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = toInt(br.readLine());

        int X = 0;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int P = toInt(st.nextToken());
            int C = toInt(st.nextToken());

            if (Math.abs(P - X) <= C) {
                X++;
            }
        }

        System.out.println(X);

    }

    private static int toInt(String val) {
        return Integer.parseInt(val);
    }
}