import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    private static List<Long> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N > 1022) {
            System.out.println(-1);
            return;
        }

        for (int i = 1; i <= 9; i++) {
            dfs(String.valueOf(i), i);
        }

        list.add(0L);
        Collections.sort(list);
        System.out.println(list.get(N));

    }

    private static void dfs(String num, int idx) {
        if (idx == -1) return;

        list.add(Long.parseLong(num));

        for (int i = idx-1; i >= 0; i--) {
            dfs(num + i, i);
        }

    }

}