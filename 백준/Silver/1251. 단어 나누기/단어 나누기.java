import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for (int i = 1; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                StringBuilder one = new StringBuilder(s.substring(0, i));
                StringBuilder two = new StringBuilder(s.substring(i, j));
                StringBuilder three = new StringBuilder(s.substring(j));

                list.add(String.valueOf(one.reverse()
                        .append(two.reverse())
                        .append(three.reverse())));
            }
        }


        Collections.sort(list);
        System.out.println(list.get(0));

    }

}