import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        String result = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .distinct()
                .sorted()
                .mapToObj(s -> s + " ")
                .collect(Collectors.joining());

        System.out.println(result);


    }

}
