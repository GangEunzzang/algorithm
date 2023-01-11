package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class baek_3052 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] list = new int[10];
        int [] mul = new int[10];

        for (int j = 0; j < list.length; j++) {
            list[j] = sc.nextInt();
        }

        for (int j = 0; j < list.length; j++) {
            mul[j] = list[j] % 42;
        }

        System.out.println(Arrays.stream(mul).distinct().count());
     }
}
