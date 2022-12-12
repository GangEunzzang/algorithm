package baekjoon;

import java.util.Scanner;

public class baek_10871 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int X = in.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {

            int value = in.nextInt();
            if (value < X) {
                sb.append(value + " ");
            }
        }

    }
}
