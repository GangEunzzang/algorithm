import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static List<List<Integer>> tree = new ArrayList<>();
    static int N, q;

    public static void main(String[] args) throws IOException {
        N = toInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            tree.add(new ArrayList<>());
        }

        while (N-- > 1) {
            st = new StringTokenizer(br.readLine());
            int a = toInt(st.nextToken());
            int b = toInt(st.nextToken());
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        q = toInt(br.readLine());
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());

            int t = toInt(st.nextToken());
            int k = toInt(st.nextToken());

            if (t == 1) {
                System.out.println(isCutVertex(k) ? "yes" : "no");
            }

            if (t == 2) {
                System.out.println("yes");
            }
        }

    }

    static boolean isCutVertex(int num) {
        return tree.get(num).size() > 1;
    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}
