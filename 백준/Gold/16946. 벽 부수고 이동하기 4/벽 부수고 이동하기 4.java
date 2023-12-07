import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N,M, count;
    static int[][] arr;
    static boolean[][] visited;
    static Map<Integer, Integer> groupCountMap = new HashMap<>();
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(split[j]) == 1 ? -1 : 0;
            }
        }

        int groupNum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && arr[i][j] == 0) {
                    count = 0;
                    dfs(i, j, groupNum);
                    groupCountMap.put(groupNum++, count);
                }
            }
        }


        Set<Integer> groups;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (arr[i][j] == -1) {
                    groups = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int mx = i + moveX[k];
                        int my = j + moveY[k];
                        if (mx < 0 || my < 0 || mx >= N  || my >= M ||  arr[mx][my] == -1) continue;
                        groups.add(arr[mx][my]);
                    }

                    sb.append((groups.stream().mapToInt(val -> groupCountMap.get(val)).sum()+1) % 10);
                } else {
                    sb.append(0);
                }

            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int x, int y, int groupNum) {
        arr[x][y] = groupNum;
        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int mx = x + moveX[i];
            int my = y + moveY[i];
            if (mx < 0 || my < 0 || mx >= N  || my >= M || visited[mx][my] || arr[mx][my] == -1) continue;
            dfs(mx, my, groupNum);
        }

    }





}
