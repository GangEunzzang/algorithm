package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class baek_4344 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int [] count = new int[n];
        double [] result = new double[n];

        for (int i = 0; i < count.length; i ++) {

            int scoreCount = sc.nextInt();
            int [] score = new int[scoreCount];

            for (int j = 0; j < score.length; j++) {
                score[j] = sc.nextInt();
            }

            long aboveAverageCount = Arrays.stream(score).filter(a -> a > Arrays.stream(score).average().orElse(0)).count();
            result[i] = (double)aboveAverageCount/score.length * 100;
        }

        for(int i = 0; i < result.length; i++) {
            System.out.println((String.format("%.3f", result[i]) + "%"));

        }
    }
}
