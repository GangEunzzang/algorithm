package baekjoon;

import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Scanner;

public class baek_1546 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double[] score = new double[n];
        double[] afterScore = new double[n];

        for (int j = 0; j < score.length; j++) {
            score[j] = sc.nextInt();
        }

        double max = Arrays.stream(score).max().orElse(0);

        for (int j = 0; j < score.length ; j++) {
            afterScore[j] = (score[j] / max) * 100;
        }

        System.out.println(Arrays.stream(afterScore).average().getAsDouble());
    }
}
