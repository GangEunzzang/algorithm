import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;
    static StringBuilder answer = new StringBuilder();
    static String str;
    static int N;


    public static void main(String[] args) throws IOException {

        while ((str = br.readLine()) != null) {
            if (str.isBlank()) break;

            N = Integer.parseInt(str);

            if (N == 0) {
                answer.append("-").append("\n");
                continue;
            }

            sb = new StringBuilder();

            int pow = (int) Math.pow(3, N);

            for (int i = 0; i < pow; i++) {
                sb.append("-");
            }

            dfs(sb.length(), 0);

            answer.append(sb).append("\n");
        }

        System.out.println(answer);
    }


    static void dfs(int size, int startIdx) {
        if (size == 1) return;


        int divSize = size / 3;
        int re = startIdx + divSize;

        for (int i = re; i < re + divSize; i++) {
            sb.setCharAt(i, ' ');
        }

        dfs(divSize, startIdx);
        dfs(divSize, startIdx + divSize * 2);

    }


}
