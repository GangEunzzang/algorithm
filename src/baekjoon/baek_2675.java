package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class baek_2675 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

//        int num = Integer.parseInt(br.readLine());
        int num = sc.nextInt();

        for (int i = 1; i <= num; i++) {

//            int lengthOfString = Integer.parseInt(br.readLine());
            int lengthOfString = sc.nextInt();
//            String string = br.readLine();
            String string = sc.nextLine();

            for (int j = 1; j <  string.length(); j++)  {
                sb.append(String.valueOf(string.charAt(j)).repeat(lengthOfString));
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
