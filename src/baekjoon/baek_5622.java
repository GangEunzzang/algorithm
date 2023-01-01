package baekjoon;

import java.util.Scanner;

public class baek_5622 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        int num = 0;

        num += S.length();

        for (int i = 0; i < S.length(); i ++) {
            char c = S.charAt(i);

            if (c == 'A' || c =='B' || c=='C') {
                num += 2;
            }

            if (c == 'D' || c =='E' || c=='F') {
                num += 3;
            }

            if (c == 'G' || c =='H' || c=='I') {
                num += 4;
            }

            if (c == 'J' || c =='K' || c=='L') {
                num += 5;
            }

            if (c == 'M' || c =='N' || c=='O') {
                num += 6;
            }

            if (c == 'P' || c =='Q' || c=='R' || c == 'S') {
                num += 7;
            }

            if (c == 'T' || c =='U' || c=='V') {
                num += 8;
            }

            if (c == 'W' || c =='X' || c=='Y' || c == 'Z') {
                num += 9;
            }
        }

        System.out.println(num);

    }
}
