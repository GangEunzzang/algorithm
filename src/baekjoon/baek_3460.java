package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_3460 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());



        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            StringBuilder binary = new StringBuilder(Integer.toBinaryString(N)).reverse();

            for (int j = 0; j < binary.length(); j++) {

                if (binary.charAt(j) == '1') {
                    sb.append(j).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
