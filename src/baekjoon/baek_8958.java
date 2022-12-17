package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class baek_8958 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        String arr[] = new String[sc.nextInt()];
        int score = 0;
        int cnt = 0;

        for ( int i = 0; i < arr.length; i++) {
            arr[i] = sc.next();
        }

        for (int i = 0; i < arr.length; i++) {
            score = 0; cnt = 0;
            for(int j = 0; j<arr[i].length(); j++) {

                if(arr[i].charAt(j) == 'O') {
                    cnt++;
                    score += cnt;
                } else {
                    cnt = 0;
                }
            }
            System.out.println(score);

        }

    }
}
