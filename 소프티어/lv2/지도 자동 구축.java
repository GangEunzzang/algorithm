import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int dot = 2;

        while (N --> 0) {
            dot = dot - 1 + dot;
        }

        System.out.println(dot * dot);

    }


}