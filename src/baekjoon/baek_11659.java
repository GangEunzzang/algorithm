package baekjoon;

import java.util.Scanner;

public class baek_11659 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int arr[] = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < M; i++) {

            int indexSum = startIndexEndIndexSum(arr, sc.nextInt(), sc.nextInt());

            sb.append(indexSum).append("\n");
        }

        System.out.println(sb);

    }

    public static int startIndexEndIndexSum(int[] arr, int start, int end) {

        int sum = 0;

        for (int i = start-1; i < end; i++) {
            sum += arr[i];
        }

        return sum;
    }
}
