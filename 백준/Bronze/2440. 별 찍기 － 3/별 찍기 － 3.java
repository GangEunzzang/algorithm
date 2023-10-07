import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) + 1;

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            sb.append("*".repeat(Math.max(0, N)));
            sb.append("\n");
        }

        System.out.println(sb);

    }
}


