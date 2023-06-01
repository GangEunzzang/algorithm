import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()) * 2;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] iqList = new int[n];

        for (int i = 0; i < n; i++) {
            iqList[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(iqList);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n / 2; i++) {
            int num = iqList[i] + iqList[n - i - 1];
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        System.out.println(max - min);
    }
}
