import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            int count = 0;
            int sum = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int candy = Integer.parseInt(st.nextToken());
            int box = Integer.parseInt(st.nextToken());
            Integer boxArray[] = new Integer[box];


            for (int i = 0; i < box; i++) {
                st = new StringTokenizer(br.readLine());
                int width = Integer.parseInt(st.nextToken());
                int height = Integer.parseInt(st.nextToken());
                boxArray[i] = width * height;
            }

            Arrays.sort(boxArray, Comparator.reverseOrder());

            for (Integer size : boxArray) {

                sum += size;
                count++;

                if (candy <= sum) {
                    break;
                }

            }
            sb.append(count).append("\n");

        }


        System.out.println(sb);
    }

}
