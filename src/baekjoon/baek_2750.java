package baekjoon;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class baek_2750 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length; j++) {

                int one = arr[i];
                int two = arr[j];

                if (two > one) {
                    arr[i] = two;
                    arr[j] = one;
                }

            }

        }


        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
