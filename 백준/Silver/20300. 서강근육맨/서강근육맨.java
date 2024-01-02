import javax.swing.*;
import java.io.*;
import java.util.*;


public class Main {

    static int INF = 1_000_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        N = toInt(br.readLine());
        arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        long answer;
        int start = 0;
        int end;

        if (N % 2 == 1) {
            answer = arr[N - 1];
            end = N - 2;

        } else {
            answer = 0;
            end = N - 1;
        }

        while (start < end) {
            answer = Math.max(arr[start++] + arr[end--], answer);
        }

        System.out.println(answer);


    }

    static int toInt(String val) {
        return Integer.parseInt(val);
    }

}




