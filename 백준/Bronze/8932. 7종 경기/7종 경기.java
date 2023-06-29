import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {

            List<Integer> list = Arrays.stream(br.readLine().split(" ")).map(i -> Integer.parseInt(i)).collect(Collectors.toList());

            int sum = 0;

            sum += (int) (9.23076 * Math.pow(26.7 - list.get(0), 1.835));
            sum += (int) (1.84523 * Math.pow(list.get(1) - 75, 1.348));
            sum += (int) (56.0211 * Math.pow(list.get(2) - 1.5, 1.05));
            sum += (int) (4.99087 * Math.pow(42.5 - list.get(3), 1.81));
            sum += (int) (0.188807 * Math.pow(list.get(4) - 210, 1.41));
            sum += (int) (15.9803 * Math.pow(list.get(5) - 3.8, 1.04));
            sum += (int) (0.11193 * Math.pow(254 - list.get(6), 1.88));

            sb.append(sum).append("\n");

        }

        System.out.println(sb);


    }

}