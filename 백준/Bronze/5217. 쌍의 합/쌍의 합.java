import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            int num = Integer.parseInt(br.readLine());
            boolean check = false;

            sb.append("Pairs for " + num + ": ");

            for (int i = 1; i <= num /2; i++) {
                if (i == num - i) continue;
                check = true;
                sb.append(i + " " + (num - i) + ", ");
            }

            if (check) sb.deleteCharAt(sb.length() - 1).deleteCharAt(sb.length() - 1);
            else sb.deleteCharAt(sb.length() - 1);

            sb.append("\n");
        }

        System.out.println(sb);

    }
}