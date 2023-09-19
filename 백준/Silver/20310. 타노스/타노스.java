import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    private static int zeroCount;
    private static int oneCount;
    private static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        char[] chars = S.toCharArray();

        for (char c : chars) {
            if (c == '0') zeroCount++;
            else oneCount++;
        }

        zeroCount /= 2;
        oneCount /= 2;

        for (int i = 0; i < chars.length; i++) {
            if (oneCount == 0) break;

            if (chars[i] == '1') {
                oneCount--;
                chars[i] = 'N';
            }
        }

        for (int i = chars.length - 1; i >= 0; i--) {
            if (zeroCount == 0) {
                break;
            }

            if (chars[i] == '0') {
                zeroCount--;
                chars[i] = 'N';
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char c : chars) {
            if (c == 'N') continue;
            sb.append(c);
        }

        System.out.println(sb);

    }

}
