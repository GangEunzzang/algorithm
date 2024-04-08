import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Map<String, Integer> encyclopediaByName = new HashMap<>();
    static Map<Integer, String> encyclopediaBySeq = new HashMap<>();


    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = toInt(st.nextToken());
        int M = toInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            encyclopediaByName.put(name, i);
            encyclopediaBySeq.put(i, name);
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (isString(name)) sb.append(encyclopediaByName.get(name));
            else sb.append(encyclopediaBySeq.get(toInt(name)));
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static boolean isString(String name) {
        return !Character.isDigit(name.charAt(0));
    }


    private static int toInt(String val) {
        return Integer.parseInt(val);
    }

}