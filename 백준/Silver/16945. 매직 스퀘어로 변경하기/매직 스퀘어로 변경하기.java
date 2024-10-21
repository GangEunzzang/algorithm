import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static List<Integer> original = new ArrayList<>();
    static List<Integer> custom = new ArrayList<>();
    static boolean[] visited = new boolean[10];

    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        original.add(Integer.MAX_VALUE); // 0번째 인덱스는 사용하지 않음
        custom.add(Integer.MAX_VALUE); // 0번째 인덱스는 사용하지 않음

        for (int i = 0; i < 3; i++) {
           st = new StringTokenizer(br.readLine());
            original.add(toInt(st.nextToken()));
            original.add(toInt(st.nextToken()));
            original.add(toInt(st.nextToken()));
        }

        dfs(1);

        System.out.println(min);
    }

    public static void dfs(int idx) {
        if (idx == 10) {
            if (checkMagicSquare()) {
                int diff = 0;
                for (int i = 1; i <= 9; i++) {
                    diff += Math.abs(original.get(i) - custom.get(i));
                }
                min = Math.min(min, diff);
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            custom.add(idx, i);
            dfs(idx + 1);
            visited[i] = false;
            custom.remove(idx);
        }
    }

    public static boolean checkMagicSquare() {
        int sum1 = custom.get(1) + custom.get(2) + custom.get(3);
        int sum2 = custom.get(4) + custom.get(5) + custom.get(6);
        int sum3 = custom.get(7) + custom.get(8) + custom.get(9);

        int sum4 = custom.get(1) + custom.get(4) + custom.get(7);
        int sum5 = custom.get(2) + custom.get(5) + custom.get(8);
        int sum6 = custom.get(3) + custom.get(6) + custom.get(9);

        int sum7 = custom.get(1) + custom.get(5) + custom.get(9);
        int sum8 = custom.get(3) + custom.get(5) + custom.get(7);

        return sum1 == 15 && sum2 == 15 && sum3 == 15 && sum4 == 15 && sum5 == 15 && sum6 == 15 && sum7 == 15 && sum8 == 15;
    }



    static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
