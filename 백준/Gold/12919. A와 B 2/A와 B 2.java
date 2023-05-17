import javax.naming.PartialResultException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    private static String S;
    private static String T;
    private static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        dfs2(T);
        System.out.println(check ? 1 : 0);
    }

    private static void dfs(StringBuilder s) {

        if (check || s.length() > T.length()) return;

        if (s.toString().equals(T)) {
            check = true;
            return;
        }

        dfs(new StringBuilder(s + "A"));
        dfs(new StringBuilder(s + "B").reverse());
    }

    private static void dfs2(String a) {
        if (a.length() < S.length() || check) return;

        if (a.equals(S)) {
            check = true;
            return;
        }

        if (a.charAt(0) == 'B') {
            dfs2(new StringBuilder(a).reverse().substring(0, a.length() - 1));
        }

        if (a.charAt(a.length() - 1) == 'A')
            dfs2(a.substring(0, a.length() - 1));
    }
}
