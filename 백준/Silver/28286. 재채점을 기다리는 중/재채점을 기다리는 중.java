import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] arr, answer;
    static int N, K, max;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken());
        K = toInt(st.nextToken());
        arr = new int[N];
        answer = new int[N];
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = toInt(st.nextToken());
            arr[i] = num;
            list.add(num);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            answer[i] = toInt(st.nextToken());
        }

        dfs(K, list);

        System.out.println(max);
    }

    private static void dfs(int count, List<Integer> list) {

        int tmp = 0;
        for (int i = 0; i < N; i++) {
            if (list.size() <= i) {
                break;
            }

            if (list.get(i) == answer[i]) {
                tmp++;
            }
        }
        max = Math.max(tmp, max);
        if (count == 0) return;

        for (int i = 0; i < N; i++) {
            if (list.size() > i) {
                List<Integer> pull = new ArrayList<>(list);
                pull.remove(i);
                dfs(count - 1, pull);
            }

            if (list.size() > i) {
                List<Integer> push = new ArrayList<>(list);
                push.add(i, -1);
                dfs(count - 1, push);
            }

        }
    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}
