import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), ":");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int index = 2;

        while (n >= index && m >= index) {

            if (n % index == 0 && m % index == 0) {
                n /= index;
                m /= index;
            } else {
                index++;
            }
        }

        System.out.println(n + ":" + m);
    }
}

