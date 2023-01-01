package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class baek_1152 {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        String S = br.readLine();
        String S = sc.nextLine();
        int cnt = 0;

        String[] splitOfS = S.split("\\s");

        cnt = splitOfS.length;

        for (String splitOf : splitOfS) {
            if (splitOf.isBlank()) {
                cnt--;
            }
        }

        System.out.println(cnt);

    }
}
