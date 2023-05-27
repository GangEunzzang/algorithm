import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        long[] arr = new long[68];
        arr[0] = arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for (int i = 4; i < 68; i++)
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3] + arr[i - 4];


        while (T-- > 0)
            sb.append(arr[Integer.parseInt(br.readLine())]).append("\n");


        System.out.println(sb);
    }

}
