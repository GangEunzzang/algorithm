package baekjoon;

import java.util.Scanner;

public class baek_1065 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        int cnt = 0;

        for (int i = 1; i <= input; i++) {

            if (i >= 100) {

                int num = i;
                while (num != 0) {
                    int temp = i % 10;
                    num = num/10;
                }

            } else {
                cnt++;
            }

        }
    }
}
