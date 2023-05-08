import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] numbers = new int[N];
        int[] counts = new int[100_001];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int maxLength = 0;
        int start = 0;
        int end = 0;

        while (start < N) {

            while (end < N && counts[numbers[end]] + 1 <= K) {
                counts[numbers[end++]]++;
            }

            maxLength = Math.max(end - start, maxLength);
            counts[numbers[start++]]--;
        }

        System.out.println(maxLength);
    }
}