import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int[] arr1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < 9; i++) {
            sum1 += arr1[i];

            if(sum1 > sum2) {
                System.out.println("Yes");
                return;
            }

            sum2 += arr2[i];
            
        }

        System.out.println("No");

    }

    static int toInt(String val) {
        return Integer.parseInt(val);
    }




}

