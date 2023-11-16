import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        int answer = 0;

        while (N-- > 0) {
            String val = br.readLine();

            if (val.equals("ENTER")) {
                set = new HashSet<>();
                continue;
            }

            if (!set.contains(val)) {
                set.add(val);
                answer++;
            }
        }

        System.out.println(answer);
    }

}