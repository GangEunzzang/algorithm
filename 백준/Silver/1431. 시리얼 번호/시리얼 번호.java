import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();

        while (N-- > 0) {
            list.add(br.readLine());
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length()) {
                    return -1;
                }

                if (o1.length() == o2.length()) {

                    int o1Count = 0;
                    int o2Count = 0;

                    for (char c : o1.toCharArray()) {
                        if (Character.isDigit(c)) o1Count += Character.getNumericValue(c);
                    }

                    for (char c : o2.toCharArray()) {
                        if (Character.isDigit(c)) o2Count += Character.getNumericValue(c);
                    }

                    if (o1Count == o2Count) {
                        return o1.compareTo(o2);
                    }
                    return Integer.compare(o1Count, o2Count);
                }
                return 1;
            }
        });

        for (String s : list) {
            System.out.println(s);
        }

    }
}