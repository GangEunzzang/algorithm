import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int[] arr = new int[20];
            StringTokenizer st = new StringTokenizer(br.readLine());

            int count = 0;
            int idx = Integer.parseInt(st.nextToken());

            for (int i = 0; i < 20; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                for (int j = i; j >= 1; j--) {
                    if (arr[j] < arr[j - 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j - 1];
                        arr[j-1] = temp;
                        count++;
                    }
                }
            }

            sb.append(idx + " " + count).append("\n");
        }

        System.out.println(sb);

    }

}