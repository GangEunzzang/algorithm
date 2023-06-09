import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            boolean check = isCheck(br.readLine());
            sb.append(check ? "Infected!" : "Good").append("\n");
        }

        System.out.println(sb);

    }

    public static boolean isCheck(String s) {
        String pattern = "^[A-F]?A+F+C+[A-F]?$";
        return Pattern.matches(pattern, s);
    }
}
