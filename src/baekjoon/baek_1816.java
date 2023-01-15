package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class baek_1816 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        long max = 0;

        for (int i = 0; i < N; i++ ) {

            long num = Long.parseLong(br.readLine());

            arr[i] = num;

            if (num > max) {
                max = num;
            }
        }


        for(int i = 2; i < Math.sqrt(max); i ++) {

            for(int j = i*i; i < max; i++) {

                bol[j] = true;

            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < arr.length; i++ ) {

            if (bol[i]) {
                sb.append("NO");
            } else {
                sb.append("YES");
            }
        }

        System.out.println(sb);
    }
}
