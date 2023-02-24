import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(br.readLine());
        int min = Math.abs(Math.subtractExact(A, B));

        for (int i = 0; i < N; i++) {

            int num = Integer.parseInt(br.readLine());
            int abs = Math.abs(Math.subtractExact(num, B));

            if (abs < min) {
                min = abs + 1;
            }

        }

        System.out.println(min);
    }

}