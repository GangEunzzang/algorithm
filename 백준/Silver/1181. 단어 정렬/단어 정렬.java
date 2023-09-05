import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        list = list.stream().distinct().collect(Collectors.toList());

        Collections.sort(list, (o1, o2) -> {
            if (o1.length() < o2.length()) {
                return -1;
            }

            else if (o1.length() > o2.length()) {
                return 1;
            }

            else {
                return o1.compareTo(o2);
            }
        });


        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s + "\n");
        }

        System.out.println(sb);
    }


}
