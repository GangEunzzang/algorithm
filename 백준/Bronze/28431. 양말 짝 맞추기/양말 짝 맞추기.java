import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(br.readLine());

            if (set.contains(num)) set.remove(num);
            else set.add(num);
        }

        System.out.println(set.iterator().next());
    }
}


