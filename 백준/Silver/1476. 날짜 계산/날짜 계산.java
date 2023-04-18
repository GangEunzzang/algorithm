import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] tokens = input.split(" ");

        int E = Integer.parseInt(tokens[0]);
        int S = Integer.parseInt(tokens[1]);
        int M = Integer.parseInt(tokens[2]);

        int i = 1;

        while (true) {
            int i1 = i % 15 == 0 ? 15 : i % 15;
            int i2 = i % 28 == 0 ? 28 : i % 28;
            int i3 = i % 19 == 0 ? 19 : i % 19;

            if (i1 == E && i2 == S && i3 == M) {
                System.out.println(i);
                break;
            }
            i++;
        }
    }
}
