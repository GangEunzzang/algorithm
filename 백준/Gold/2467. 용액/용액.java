import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N,a,b;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = N-1;

        while (start < end) {
            int num = arr[start] + arr[end];

            if (num == 0) {
                a = arr[start];
                b = arr[end];                
                break;
            }

            if (Math.abs(num) < Math.abs(min)) {
                a = arr[start];
                b = arr[end];
                min = num;
            }

            if (num < 0) start++;
             else end--;

        }

        System.out.println(a + " " + b);
    }


}
