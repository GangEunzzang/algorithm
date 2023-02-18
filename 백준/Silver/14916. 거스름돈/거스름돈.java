import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        if (N % 5 == 0) {
            System.out.println(N / 5);
            return;
        }

        if (N < 9) {
            if (N % 2 == 0) {
                System.out.println(N / 2);
                return;
            }
        }

        for (int i = N / 5; i >= 1; i--) {

            int num = N - (5 * i);

            if (num % 2 == 0) {
                count += num / 2;
                count += i;
                break;
            }
        }

        System.out.println(count == 0 ? -1 : count);
    }

}
