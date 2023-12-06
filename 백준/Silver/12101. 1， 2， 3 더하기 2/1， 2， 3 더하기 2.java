import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int n,m;
    static List<String> results = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(0, "");

        Collections.sort(results);

        if (m - 1 >= results.size()) {
            System.out.println(-1);
        } else {
            System.out.println(results.get(m - 1));
        }


    }

    static void dfs(int sum, String val) {
        if (sum >= n) {
            if (sum == n) {
                results.add(val);
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if (val.isBlank()) {
                dfs(sum + i, String.valueOf(i));
            } else {
                dfs(sum + i, val + "+" + i);
            }
        }
    }


}
