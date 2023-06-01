import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> tree = new TreeMap<>();

        String line = br.readLine();
        int size = 0;

        while (true) {
            tree.put(line, tree.getOrDefault(line, 0) + 1);
            size ++;
            
            line = br.readLine();
            if (line == null || line.length() == 0) break;
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : tree.entrySet()) {
            double v = (double) stringIntegerEntry.getValue() / size * 100;
            String format = String.format("%.4f", v);

            System.out.println(stringIntegerEntry.getKey() + " " + format);

        }
    }

}
