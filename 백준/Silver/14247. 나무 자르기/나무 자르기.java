import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];

        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr, (Comparator.comparingInt(o -> o[1])));

        long sum = 0;

        for (int i = 0; i < N; i++) {
            int[] tree = arr[i];
            sum += tree[0] + (tree[1] * i);
        }


        System.out.println(sum);

    }


}
