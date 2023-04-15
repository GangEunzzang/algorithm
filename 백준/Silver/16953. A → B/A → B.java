import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    private static int targetNumber;

    private static boolean check;

    private static int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int startNumber = Integer.parseInt(st.nextToken());
        targetNumber = Integer.parseInt(st.nextToken());

        dfs(startNumber, 1);

        System.out.println(check ? ans : -1);

    }

    private static void dfs(long num, int count) {

        if (num > targetNumber) {
            return;
        }
        if (num == targetNumber) {
            ans = count;
            check = true;
            return;
        }
        dfs(Long.parseLong(num + "1"), count + 1);
        dfs(num * 2, count + 1);
    }
}


