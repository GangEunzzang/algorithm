import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        int N = toInt(br.readLine());

        Set<String> set = new HashSet<>();
        set.add("ChongChong");

        while (N-- > 0) {
            String[] split = br.readLine().split(" ");
            String one = split[0];
            String two = split[1];

            if (set.contains(one) || set.contains(two)) {
                set.add(one);
                set.add(two);
            }

        }

        System.out.println(set.size());

    }

    private static int toInt(String val) {
        return Integer.parseInt(val);
    }

}
