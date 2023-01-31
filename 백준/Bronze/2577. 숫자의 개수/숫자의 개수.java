import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[10];

        int num = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());

        String s = String.valueOf(num);

        for (int i = 0; i < s.length();  i ++ ) {
            int numericValue = Character.getNumericValue(s.charAt(i));
            arr[numericValue]++;
        }

        for (int i = 0; i <= 9; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }
}