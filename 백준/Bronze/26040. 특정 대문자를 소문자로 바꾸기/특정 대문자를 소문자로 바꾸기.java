import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        sb.append(A);

        String[] B = br.readLine().split(" ");

        for (String s : B) {
            for (int i = 0; i < A.length(); i++) {
                if (A.charAt(i) == s.charAt(0)) sb.replace(i, i + 1, s.toLowerCase());
            }
        }

        System.out.println(sb);

    }
}