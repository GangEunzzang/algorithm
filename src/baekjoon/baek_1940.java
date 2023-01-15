package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baek_1940 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int count = 0;
        int startIndex = 0;
        int sum = 0;

        int[] arr = new int[N];



        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        arr = Arrays.stream(arr).sorted().toArray();

        int endIndex = arr.length-1;


        while (startIndex < endIndex) {

            int arrSum = arr[startIndex] + arr[endIndex];

//            System.out.print("startIndex = " + startIndex + " ");
//            System.out.print("endIndex = " + endIndex+ " ");
//            System.out.println("arrSum = " + arrSum);

            if (arrSum > M) {
                endIndex--;
            }

            if (arrSum < M) {
                startIndex++;
            }

            if (arrSum == M) {
                count++;
                endIndex--;
            }
        }

        System.out.println(count);
    }
}
