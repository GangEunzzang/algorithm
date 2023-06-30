import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static double[] arr;
    private static double max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new double[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            double num = 1;
            for (int j = i; j < N; j++) {
                num *= arr[j];
                max = Math.max(max, num);
            }
        }

        System.out.println(String.format("%.3f", max));

    }

}