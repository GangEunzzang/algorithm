import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] balls = new boolean[N];

        String s = br.readLine();

        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == 'R') balls[i] = true;
        }

        int min = Integer.MAX_VALUE;
        boolean check = false;
        int count = 0;

        for (int i = 0; i < N; i++) {
            if (check && balls[i]) {
                count++;
                continue;
            }
            if (!balls[i]) check = true;
        }
        min = Math.min(min, count);

        count = 0;
        check = false;
        for (int i = 0; i < N; i++) {
            if (check && !balls[i]) {
                count++;
                continue;
            }
            if (balls[i]) check = true;
        }

        min = Math.min(min, count);

        count = 0;
        check = false;
        for (int i = N-1; i >= 0; i--) {
            if (check && !balls[i]) {
                count++;
                continue;
            }
            if (balls[i]) check = true;
        }
        min = Math.min(min, count);


        count = 0;
        check = false;
        for (int i = N-1; i >= 0; i--) {
            if (check && balls[i]) {
                count++;
                continue;
            }
            if (!balls[i]) check = true;
        }
        min = Math.min(min, count);

        System.out.println(min);
    }
}
