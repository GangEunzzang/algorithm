import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        Set<String> A = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toSet());
        Set<String> B = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toSet());

        List<Integer> list = A.stream()
                .filter(val -> !B.contains(val))
                .mapToInt(Integer::valueOf)
                .boxed()
                .sorted()
                .collect(Collectors.toList());

        String result = list.stream()
                .map(i -> i + " ")
                .collect(Collectors.joining());

        System.out.println(list.size());

        if (!list.isEmpty()) {
            System.out.println(result);
        }

    }
}
