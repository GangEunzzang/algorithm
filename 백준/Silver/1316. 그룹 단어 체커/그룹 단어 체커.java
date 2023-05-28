import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] checkAlphabet = new boolean[27];
        int count = 0;

        first:
        while (N-- > 0) {
            String word = br.readLine();
            char[] toCharArray = word.toCharArray();
            Arrays.fill(checkAlphabet, false);

            char previousAlphabet = 0;

            for (char c : toCharArray) {
                if (checkAlphabet[c-'a'] && previousAlphabet != c) {
                    continue first;
                }
                checkAlphabet[c-'a'] = true;
                previousAlphabet = c;
            }

            count++;
        }

        System.out.println(count);
    }

}
