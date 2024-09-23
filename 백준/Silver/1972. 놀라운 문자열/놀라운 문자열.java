
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        while (true) {
            String s = br.readLine();
            if (s.equals("*")) break;
            System.out.println(isSurprising(s) ? s + " is surprising." : s + " is NOT surprising.");
        }
    }

    static boolean isSurprising(String s) {
        int n = s.length();

        for (int d = 1; d < n; d++) {
            Set<String> set = new HashSet<>();
            for (int i = 0; i + d < n; i++) {
                String pair = "" + s.charAt(i) + s.charAt(i + d);

                if (set.contains(pair)) return false;
                set.add(pair);
            }
        }
        return true;
    }

    private static int toInt(String val) {
        return Integer.parseInt(val);
    }

}
