import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            if(N == 0) break;

            List<Integer> list = new ArrayList<>();

            int lastNum = 0;
            while (N-- > 0) {
                int num = Integer.parseInt(st.nextToken());
                if (lastNum == num) continue;
                lastNum = num;
                list.add(num);
            }

            for (Integer num : list) {
                sb.append(num).append(" ");
            }

            sb.append("$ \n");
        }

        System.out.println(sb);


    }
}


