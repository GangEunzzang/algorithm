import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        N = toInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = toInt(st.nextToken());
            arr[i][1] = toInt(st.nextToken());
        }

        Arrays.sort(arr, Comparator.comparingInt(o -> o[1]));

        int nowTime = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int durationTime = arr[i][0];
            int entTime = arr[i][1];

            if (nowTime + durationTime > entTime) {
                System.out.println(-1);
                return;
            }

            minDiff = Math.min(minDiff, Math.abs(entTime - (nowTime + durationTime)));
            nowTime += durationTime;
        }

        System.out.println(minDiff);
    }

    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}

