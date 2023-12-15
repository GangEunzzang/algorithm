import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N,K, M;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken()); // 김밥의 개수
        K = toInt(st.nextToken()); // 꼬다리의 길이
        M = toInt(st.nextToken()); // 김밥조각의 최소 개수

        for (int i = 0; i < N; i++) {
            int num = toInt(br.readLine());
            if (num <= K) continue;
            if (num >= K * 2) list.add(num - K * 2);
            if (num < K * 2) list.add(num - K);
        }

        int start = 1;
        int end = 1_000_000_000;
        int result = -1;

        while (start <= end) {
            int mid = (end + start) / 2;

            if (getSum(mid) >= M) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid -1;
            }
        }

        System.out.println(result);

    }

    static int getSum(int div) {
        return list.stream().mapToInt(i -> i / div).sum();
    }

    static int toInt(String val) {
        return Integer.parseInt(val);
    }




}

