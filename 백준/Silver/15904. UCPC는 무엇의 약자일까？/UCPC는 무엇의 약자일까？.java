import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        char[] chars = br.readLine().toCharArray();

        List<Character> list = List.of('U', 'C', 'P', 'C');
        int idx = 0;
        boolean can = false;

        for (char c : chars) {
            if (c == list.get(idx)) {
                if ( ++idx >= list.size()) {
                    can = true;
                    break;
                }
            }
        }

        System.out.println(can ? "I love UCPC" : "I hate UCPC");

    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}
