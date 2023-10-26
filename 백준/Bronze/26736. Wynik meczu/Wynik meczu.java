import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] array = br.readLine().toCharArray();

        int aCount = 0;
        int bCount = 0;

        for (char c : array) {
            if (c == 'A') {
                aCount++;
            } else {
                bCount++;
            }
        }

        System.out.println(aCount + " : " + bCount);
    }

}


