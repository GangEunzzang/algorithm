import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] A = new int[T];
        int[] B = new int[T];

        int sum = 0;

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < T; j++) {

                int num = Integer.parseInt(st.nextToken());

                if (i == 1) {
                    B[j] = num;
                }

                if (i == 0) {
                    A[j] = num;
                }


            }
        }

        desc(A);
        asc(B);

        for (int i = 0; i < A.length; i++) {
            int value = A[i] * B[i];
            sum += value;
        }

        System.out.println(sum);
    }

    public static void desc(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }

        }

    }

    public static void asc(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[i] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }

        }

    }
}
