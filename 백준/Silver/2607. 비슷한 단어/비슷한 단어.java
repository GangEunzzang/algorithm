import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String standard;
    static int res = 0;
    static int[] alphabet = new int[26];
    static int[] check;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        standard = br.readLine();
        for (int i = 0; i < standard.length(); i++) {
            int idx = standard.charAt(i) - 'A';
            alphabet[idx]++;
        }

        for (int i = 0; i < N - 1; i++) {
            check = alphabet.clone();
            String curr = br.readLine();

            if (Math.abs(curr.length() - standard.length()) > 1) continue;

            int cnt = 0;

            for (int j = 0; j < curr.length(); j++) {
                int idx = curr.charAt(j) - 'A';
                if (check[idx] > 0) {
                    cnt++;
                    check[idx]--;
                }
            }

            if (standard.length() - 1 == curr.length() && cnt == curr.length()) res++;

            if (standard.length() + 1 == curr.length() && cnt == standard.length()) res++;

            if (standard.length() == curr.length()) {
                if (cnt == standard.length()) res++;
                else if (cnt == standard.length() - 1) res++;
            }

        }

        System.out.println(res);
    }
}