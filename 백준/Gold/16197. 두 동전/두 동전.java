import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, coinCount;
    static char[][] arr;
    static boolean[][][][] visited;
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};
    static int[][] coinPoint = new int[2][2];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        visited = new boolean[N][M][N][M];

        for (int i = 0; i < N; i++) {
            char[] array = br.readLine().toCharArray();

            for (int j = 0; j < M; j++) {
                arr[i][j] = array[j];

                if (array[j] != 'o') continue;

                if (coinCount == 0) {
                    coinPoint[0][0] = i;
                    coinPoint[0][1] = j;
                    coinCount++;
                } else {
                    coinPoint[1][0] = i;
                    coinPoint[1][1] = j;
                }
            }
        }

        System.out.println(bfs());

    }

    static int bfs() {
        Queue<Coin> q = new LinkedList<>();
        q.add(new Coin(coinPoint[0][0], coinPoint[0][1], coinPoint[1][0], coinPoint[1][1], 0));
        visited[coinPoint[0][0]][coinPoint[0][1]][coinPoint[1][0]][coinPoint[1][1]] = true;

        while (!q.isEmpty()) {
            Coin coin = q.poll();

            if (coin.count >= 10 ) break;

            for (int i = 0; i < 4; i++) {
                int coin1Mx = coin.coin1X + moveX[i];
                int coin1My = coin.coin1Y + moveY[i];
                int coin2Mx = coin.coin2X + moveX[i];
                int coin2My = coin.coin2Y + moveY[i];

                // 둘다 떨어진 경우 탐색 x
                if (!isRangeCheck(coin1Mx, coin1My) && !isRangeCheck(coin2Mx, coin2My)) continue;

                // 둘다 보드판 밖으로 떨어지지 않은 경우
                if (isRangeCheck(coin1Mx, coin1My) && isRangeCheck(coin2Mx, coin2My)) {
                    // 둘다 벽이면 방문x
                    if (arr[coin1Mx][coin1My] == '#' && arr[coin2Mx][coin2My] == '#') continue;

                    if (arr[coin1Mx][coin1My] == '#') {
                        coin1Mx = coin.coin1X;
                        coin1My = coin.coin1Y;
                    }

                    if (arr[coin2Mx][coin2My] == '#') {
                        coin2Mx = coin.coin2X;
                        coin2My = coin.coin2Y;
                    }

                    visited[coin1Mx][coin1My][coin2Mx][coin2My] = true;

                    q.add(new Coin(coin1Mx, coin1My, coin2Mx, coin2My, coin.count + 1));
                    continue;
                }
                 
                return coin.count + 1;

            }
        }

        return -1;
    }

    static boolean isRangeCheck(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < M;
    }

    static class Coin {
        int coin1X;
        int coin1Y;
        int coin2X;
        int coin2Y;
        int count;

        public Coin(int coin1X, int coin1Y, int coin2X, int coin2Y, int count) {
            this.coin1X = coin1X;
            this.coin1Y = coin1Y;
            this.coin2X = coin2X;
            this.coin2Y = coin2Y;
            this.count = count;
        }
    }

}
