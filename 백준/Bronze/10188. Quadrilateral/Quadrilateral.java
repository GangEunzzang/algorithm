import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int i = 0; i < y; i++) {
                if (i > 0) sb.append("\n");
                for (int j = 0; j < x; j++) {
                    sb.append("X");
                }
            }

            sb.append("\n").append("\n");
        }

        System.out.println(sb.deleteCharAt(sb.length()-1));


    }
}
