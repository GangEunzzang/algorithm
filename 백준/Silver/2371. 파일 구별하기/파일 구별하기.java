
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = toInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        int maxListSize = 0;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            List<Integer> innerList = new ArrayList<>();
            while (st.hasMoreTokens()) {
                innerList.add(toInt(st.nextToken()));
            }
            list.add(innerList);
            maxListSize = Math.max(maxListSize, innerList.size());
        }

        Map<Integer, StringBuilder> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(i, new StringBuilder());
        }

        int k = 0;
        Set<String> set = new HashSet<>();

        while (k < maxListSize) {
            set.clear();
            for (int i = 0; i < list.size(); i++) {
                List<Integer> integers = list.get(i);
                String value = k >= integers.size() ? "0" : integers.get(k).toString();
                StringBuilder append = map.get(i).append(value);
                set.add(append.toString());
            }

            if (set.size() == list.size()) {
                break;
            }
            k++;
        }

        System.out.println(k + 1);
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }
}
