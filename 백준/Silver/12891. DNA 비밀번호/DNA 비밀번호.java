import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int s = toInt(st.nextToken()); // 문자열의 길이
        int p = toInt(st.nextToken()); // 부분 문자열의 길이
        String dna = br.readLine();

        st = new StringTokenizer(br.readLine());
        int a = toInt(st.nextToken());
        int c = toInt(st.nextToken());
        int g = toInt(st.nextToken());
        int t = toInt(st.nextToken());

        int[] curAlphabetCounts = new int[27];

        int result = 0;

        for (int i = 0; i < p; i++) {
            curAlphabetCounts[dna.charAt(i) - 'A']++;
        }

        for (int i = p; i <= s; i++) {
            if (curAlphabetCounts[0] >= a &&
                    curAlphabetCounts[2] >= c &&
                    curAlphabetCounts[6] >= g &&
                    curAlphabetCounts[19] >= t) {
                result++;
            }
            
            if (i == s) break;
            curAlphabetCounts[dna.charAt(i) - 'A']++;
            curAlphabetCounts[dna.charAt(i - p) - 'A']--;
        }

        System.out.println(result);
    }

    private static int toInt(String value) {
        return Integer.parseInt(value);
    }
}
