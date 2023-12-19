import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws IOException {
        N = toInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = toInt(st.nextToken()) + 1_000_000_000;
            arr[i][1] = toInt(st.nextToken()) + 1_000_000_000;
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1 != o2) return o1[0] - o2[0];
            return o2[1] - o2[0];
        });

        int start = 0;
        int end = 0;
        long sum = 0;

        for (int i = 0; i < N; i++) {
            int curStart = arr[i][0];
            int curEnd = arr[i][1];

            if (curStart > end) {
                sum += end - start;
                start = curStart;
                end = curEnd;
                continue;
            }

            if (curEnd > end) {
                end = curEnd;
            }
        }

        sum += end - start;
        System.out.println(sum);
    }

    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}

