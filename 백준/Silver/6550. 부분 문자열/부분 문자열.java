import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        String input = "";

        while ((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            String s = st.nextToken();
            String t = st.nextToken();

            int sIndex = 0;

            for (int i = 0; i < t.length(); i++) {
                if (sIndex == s.length()) {
                    break;
                }
                if (t.charAt(i) == s.charAt(sIndex)) {
                    sIndex++;
                }
            }

            sb.append(sIndex == s.length() ? "Yes" : "No").append("\n");
        }

        System.out.println(sb);

    }


    private static int toInt(String value) {
        return Integer.parseInt(value);
    }
}
