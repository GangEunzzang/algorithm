import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        int count = 0;

        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();
        String target = sc.nextLine();

        boolean contains = word.contains(target);

        if (!contains) {
            System.out.println(0);
            return;
        }

        while (true) {
            int i = word.indexOf(target);
            if (i == -1) {
                break;
            }
            count++;
            word = word.substring(i + target.length(), word.length());
        }
        System.out.println(count);
    }
    
}
