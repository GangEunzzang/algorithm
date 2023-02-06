import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;

        int changeMoney = 1000 - N;

        while (changeMoney != 0 ) {

            if (changeMoney / 500 >= 1 ) {
                int change = changeMoney / 500;
                changeMoney = changeMoney - change * 500;
                count += change;
            }

            if (changeMoney / 100 >= 1) {
                int change = changeMoney / 100;
                changeMoney = changeMoney - change * 100;
                count += change;
            }

            if (changeMoney / 50 >= 1) {
                int change = changeMoney / 50;
                changeMoney = changeMoney - change * 50;
                count += change;
            }

            if (changeMoney / 10 >= 1) {
                int change = changeMoney / 10;
                changeMoney = changeMoney - change * 10;
                count += change;
            }

            if (changeMoney / 5 >= 1) {
                int change = changeMoney / 5;
                changeMoney = changeMoney - change * 5;
                count += change;
            }

            if (changeMoney / 1 >= 1) {
                int change = changeMoney / 1;
                changeMoney = changeMoney - change * 1;
                count += change;
            }

        }

        System.out.println(count);

    }
}
