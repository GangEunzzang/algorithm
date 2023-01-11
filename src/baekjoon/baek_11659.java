package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class baek_11659 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int[] sumArrNum = new int[N+1];

        for (int i = 1; i <= N; i++) {
            sumArrNum[i] = sumArrNum[i-1] + Integer.parseInt(st.nextToken());
        }


        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            int ii = Integer.parseInt(st.nextToken());
            int jj = Integer.parseInt(st.nextToken());

            sb.append(sumArrNum[jj] - sumArrNum[ii-1]).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    public static int startIndexEndIndexSum(int[] arr, int start, int end) {

        System.out.println("start = " + start);
        System.out.println("end = " + end);
        int sum = 0;

        for (int i = start-1; i < end; i++) {
            sum += arr[i];
        }

        return sum;
    }
}
