import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] house;
    static boolean[][] visited;

    static int N;
    static int count = 0, number = 0;

    static int[] nx = {-1, 1, 0, 0};
    static int[] ny = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        N = Integer.parseInt(br.readLine());

        house = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < N; j++) {
                int num = Character.getNumericValue(s.charAt(j));
                house[i][j] = num;
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (house[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    number++;
                    dfs(i,j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (Integer integer : list) {
            System.out.println(integer);
        }


    }

    static void dfs(int x, int y) {

        visited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int a = x + nx[i];
            int b = y + ny[i];

            if (a < 0 || b < 0 || a >= N || b >= N) {
                continue;
            }

            if (house[a][b] == 1 && !visited[a][b]) {
                dfs(a, b);

            }
        }

    }



}