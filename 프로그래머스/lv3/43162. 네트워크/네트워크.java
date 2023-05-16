import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Solution {

    private static List<List<Integer>> network = new ArrayList<>();
    private static boolean[] visited;
    private static int count = 0;

    public int solution(int n, int[][] computers) {

        visited = new boolean[n+1];

        for (int i = 0; i <= n; i++) {
            network.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int computer = computers[i][j];
                if (computer == 1) {
                    network.get(i).add(j);
                    network.get(j).add(i);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            List<Integer> list = network.get(i);
            for (Integer num : list) {
                if (!visited[num]) {
                    dfs(num);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(int x) {

        visited[x] = true;

        List<Integer> list = network.get(x);

        for (int i = 0; i < list.size(); i++) {
            Integer work = list.get(i);
            if (visited[work]) continue;
            dfs(work);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
    }
}
