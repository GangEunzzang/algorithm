import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static StringBuilder target;

    private static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String button = br.readLine();
        StringBuilder now = new StringBuilder(button);
        StringBuilder now2 = new StringBuilder(button);
        target = new StringBuilder(br.readLine());

        int count = 0;
        int count2 = 0;

        if (target.charAt(0) == 1) {
            swap(now2, 0);
            count2++;
        } else {
            swap(now, 0);
            count++;
        }


        for (int i = 1; i < N; i++) {
            if (target.charAt(i-1) !=  now.charAt(i-1)) {
                count++;
                swap(now, i);
            }

            if (target.charAt(i-1) !=  now2.charAt(i-1)) {
                count2++;
                swap(now2, i);
            }
        }

        if (now.toString().equals(target.toString()) && now2.toString().equals(target.toString())) {
            System.out.println(Math.min(count2, count));
            return;
        }

        if (now.toString().equals(target.toString())) {
            System.out.println(count);
            return;
        }

        if (now2.toString().equals(target.toString())) {
            System.out.println(count2);
            return;
        }

        System.out.println(-1);
    }



    private static void swap(StringBuilder data, int idx) {
        for (int i = idx - 1; i <= idx + 1; i++) {
            if (i >= 0 && i < N) {
            boolean isTure = data.charAt(i) == '0';
            data.setCharAt(i, isTure ? '1' : '0');
            }

        }

    }
}
