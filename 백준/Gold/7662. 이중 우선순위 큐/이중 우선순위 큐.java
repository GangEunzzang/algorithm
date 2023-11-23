import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();

            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                String check = st.nextToken();
                int val = Integer.parseInt(st.nextToken());
                if (check.equals("I")) {
                    treeMap.put(val, treeMap.getOrDefault(val, 0) + 1);
                }

                if (check.equals("D") && treeMap.size() > 0) {

                    if (val == 1) {
                        Map.Entry<Integer, Integer> lastEntry = treeMap.lastEntry();

                        if (lastEntry.getValue() == 1) {
                            treeMap.remove(lastEntry.getKey());
                        }

                        if (lastEntry.getValue() > 1) {
                            treeMap.put(lastEntry.getKey(), lastEntry.getValue() - 1);
                        }
                    }

                    if (val == -1) {
                        Map.Entry<Integer, Integer> firstEntry = treeMap.firstEntry();

                        if (firstEntry.getValue() == 1) {
                            treeMap.remove(firstEntry.getKey());
                        }

                        if (firstEntry.getValue() > 1) {
                            treeMap.put(firstEntry.getKey(), firstEntry.getValue() - 1);
                        }
                    }

                }
            }

            if (treeMap.isEmpty()) {
                sb.append("EMPTY");
            } else {
                sb.append(treeMap.lastKey() + " " + treeMap.firstKey());
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }



}