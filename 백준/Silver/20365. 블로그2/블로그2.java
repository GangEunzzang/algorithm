import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split("");

        int redCount = 1;
        int blueCount = 1;
        int colorCheck = 3;

        // R -> 0;
        // B -> 1;

        for (String s : arr) {
            if (s.equals("B")) {
                if (colorCheck == 1) continue;
                colorCheck = 1;
                blueCount++;
            } else {
                if (colorCheck == 0) continue;
                    colorCheck = 0;
                    redCount++;
            }
        }

        System.out.println(Math.min(redCount, blueCount));


    }

}