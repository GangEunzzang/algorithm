import javax.swing.*;
import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Main {

    static int INF = 1_000_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static List<BigInteger> answers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = toInt(br.readLine());

        while (N-- > 0) {
            char[] array = br.readLine().toCharArray();
            String s = "";

            for (char c : array) {
                if (Character.isDigit(c)) {
                    s += c;
                    continue;
                }

                if (!s.isBlank()) answers.add(new BigInteger(s));
                s = "";
            }

            if (!s.isBlank()) answers.add(new BigInteger(s));
        }

        Collections.sort(answers);

        for (BigInteger answer : answers) {
            sb.append(answer).append("\n");
        }

        System.out.println(sb);

    }

    static int toInt(String val) {
        return Integer.parseInt(val);
    }

}




