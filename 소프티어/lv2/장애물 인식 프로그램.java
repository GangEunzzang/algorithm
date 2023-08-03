import java.util.*;
import java.io.*;
import java.util.stream.IntStream;


public class Main {

    private static int N;
    private static int[][] arr;
    private static boolean[][] visited;
    private static List<Integer> hurdleAreaCountList = new ArrayList<>();
    private static int areaCount;

    private static final int[] moveX = {-1, 1, 0, 0};
    private static final int[] moveY = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < N ; j++) {
                if (ch[j] == '0') continue;
                arr[i][j] = 1;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(visited[i][j] || arr[i][j] == 0) continue;
                areaCount = 1;
                dfs(i, j);
                hurdleAreaCountList.add(areaCount);
            }
        }
        Collections.sort(hurdleAreaCountList);

        System.out.println(hurdleAreaCountList.size());
        hurdleAreaCountList.forEach(System.out::println);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;


        for (int i = 0; i < 4; i++) {
            int mx = x + moveX[i];
            int my = y + moveY[i];
            if(mx < 0 || my < 0 || mx >= N || my >= N || arr[mx][my] == 0 || visited[mx][my]) continue;
            areaCount++;
            dfs(mx, my);
        }

    }


}