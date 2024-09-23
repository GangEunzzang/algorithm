
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = toInt(st.nextToken());
        int L = toInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = IntStream.range(0, N)
                .map(i -> toInt(st.nextToken()))
                .sorted()
                .toArray();

        int curPoint = arr[0];
        int result = 0;

        for (int i = 1; i < N; i++) {
            if (arr[i] - curPoint >= L) {
                result++;
                curPoint = arr[i];
            }
        }

        System.out.println(result + 1);


    }


    private static int toInt(String val) {
        return Integer.parseInt(val);
    }

}
