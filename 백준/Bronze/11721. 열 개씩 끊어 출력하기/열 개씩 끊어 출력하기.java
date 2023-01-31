import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        int count = 0;

        for (int i = 0; i < s.length(); i++ ) {
            count++;
            sb.append(s.charAt(i));

            if (count % 10 == 0) {
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}