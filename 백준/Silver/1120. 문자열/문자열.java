import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        int diff = b.length() - a.length();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= diff; i++) {
            int tmp = 0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(j + i)) {
                    tmp++;
                }
            }
            min = Math.min(min, tmp);
        }

        System.out.println(min);

    }

    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}
