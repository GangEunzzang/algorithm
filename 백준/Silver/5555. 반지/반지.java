import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String searchRing = br.readLine();

        int answer = 0;
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            String ring = br.readLine();
            StringBuilder sb = new StringBuilder(ring + ring);
            if (sb.toString().contains(searchRing)) {
                answer++;
            }
        }

        System.out.println(answer);

    }
}


