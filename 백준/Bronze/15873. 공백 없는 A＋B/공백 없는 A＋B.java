import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int number;
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        if (s.length() == 4) System.out.println(20);

        if (s.length() == 3) {
            findNumber();
            System.out.println(number + 10);
        }

        if (s.length() == 2) {
            int num = 0;

            for (int i = 0; i < s.length(); i++) {
                num += s.charAt(i) - '0';
            }

            System.out.println(num);
        }

    }

    static void findNumber() {
        for (int i = 0; i < s.length(); i++) {
            int check = s.charAt(i) - '0';
            if (check == 0) continue;
            number = Math.max(number, check);
        }
    }

}
