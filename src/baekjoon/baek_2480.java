package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class baek_2480 {

    public static void main(String[] args) throws IOException {

        Scanner sc =  new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();

        for (int i = 1; i <= 9; i++ ) {

            sb.append(N).append(" * ").append(i).append(" = ").append(N * i).append("\n");
        }

        System.out.println(sb);

    }
}
