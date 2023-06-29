import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int max = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            max = Math.max(num, max);
            arr[i] = num;
        }

        char idx = 'A';

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            if (arr[i] == max) {
                sb.append(idx);
            }

            idx++;
        }

        System.out.println(sb);
    }
}