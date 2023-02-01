import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int sum = 0;

        int arr[] = new int[9];
        int check[] = new int[9];
        int answer[] = new int[7];

        for(int i = 1; i <= 8; i++ ) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            check[i] = num;
        }

        desc(arr);


        for (int i = 1; i <= 5; i++ ) {
            int num = arr[i];
            sum += num;

            for(int j = 1; j <= 8; j++) {
                if(num == check[j]) {
                    answer[i] = j;
                }

            }
        }

        Arrays.sort(answer);

        for (int j = 2; j < answer.length; j++) {
            sb.append(answer[j]).append(" ");
        }

        System.out.println(sum);
        System.out.println(sb);


    }

    public static void desc (int[] arr) {

        for (int i = 1; i < arr.length; i++ ) {

            for (int j = i+1; j < arr.length; j++ ) {

                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }

        }

    }
}