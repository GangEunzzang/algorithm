import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.IntStream.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N,K,T;
    static int[] arr;
    static int[] dirX = {-1, 0, 1, 0};
    static int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken());
        K = toInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = toInt(st.nextToken());
        }

        Arrays.sort(arr);

        if (K <= 2) {
            System.out.println(arr[N-1]);
        } else {
            solution();
        }
    }

    private static void solution() {

        int high = N - 2;
        int low = 0 ;
        long answer = arr[N - 1];

        int cnt = (K - 1)/ 2;

        while (cnt-- > 0) {
            answer += arr[high--] - arr[low++];
        }

        System.out.println(answer);
    }


    static int toInt(String s) {
        return Integer.parseInt(s);
    }


}
