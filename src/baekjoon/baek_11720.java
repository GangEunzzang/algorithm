package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class baek_11720 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String count = br.readLine();

        String arr = br.readLine();

        int sum = 0;

        for (int i = 0; i < arr.length(); i++) {
            int indexNum = Integer.parseInt(String.valueOf(arr.charAt(i)));
            sum += indexNum;
        }

        System.out.println( sum);

    }

}
