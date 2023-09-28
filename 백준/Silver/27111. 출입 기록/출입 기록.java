import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> check = new HashSet<>();
        int result = 0;

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (b == 0) {
                if (check.contains(a)) {
                    check.remove(a);
                } else {
                    result++;
                }
            }

            if (b == 1) {
                if (check.contains(a)) {
                    result++;
                } else {
                    check.add(a);
                }
            }
        }

        System.out.println(result + check.size());

    }
}


