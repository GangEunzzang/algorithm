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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt((st.nextToken()));
            int end = Integer.parseInt((st.nextToken()));
            int num = Integer.parseInt(st.nextToken());

            for (int i = start; i <= end; i++) {
                arr[i] = num;
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
