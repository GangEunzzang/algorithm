import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int[] answerArr;
    private static int[] arr = new int[10];
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        answerArr = Arrays.stream(br.readLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        dfs(0);

        System.out.println(result);
    }

    private static void dfs(int depth) {
        if (depth == 10) {
            int sum = 0;

            for (int i = 0; i < depth; i++) {
                if (arr[i] == answerArr[i]) sum++;
                if (sum >= 5) {
                    result++;
                    break;
                }
            }
            return;
        }


        for (int j = 1; j <= 5; j++) {
            if (depth >= 2 && arr[depth - 2] == arr[depth - 1] && arr[depth - 1] == j) continue;
            arr[depth] = j;
            dfs(depth + 1);
        }
    }
}
