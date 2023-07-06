import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String s = br.readLine();
            int a = Integer.parseInt(s);
            int b = Integer.parseInt(new StringBuilder(s).reverse().toString());

            String result = Integer.toString(a + b);
            String reverse = new StringBuilder(result).reverse().toString();
            if (result.equals(reverse)) sb.append("YES");
            else sb.append("NO");
            
            sb.append("\n");

        }

        System.out.println(sb);
    }
}

