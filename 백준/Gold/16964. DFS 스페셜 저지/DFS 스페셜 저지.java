import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> list;
    static int[] expect;
    static int[] parent;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        visit = new boolean[n + 1];
        expect = new int[n + 1];
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            expect[i] = Integer.parseInt(st.nextToken());
        }

        if (expect[1] != 1) { // 입력 값의 첫번째 값이 1이 아니면
            System.out.println(0);
            System.exit(0);
        }

        dfs(1, 2);
        System.out.println(1);

    }

    public static void dfs(int cur, int idx) {
        visit[cur] = true;

        int cnt = 0;
        for (int next : list.get(cur)) {
            if (!visit[next]) {
                visit[next] = true;
                parent[next] = cur; // 부모 저장
                cnt++;
            }
        }
        if (cnt == 0) return; // 자식이 없으면 리턴

        int expectNum = expect[idx];
        if (parent[expectNum] != cur) { // 부모가 맞지 않다면
            System.out.println(0);
            System.exit(0);
        }
        dfs(expectNum, idx + 1);
    }

}