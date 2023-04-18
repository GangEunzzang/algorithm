import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Year;
import java.util.*;

public class Main {

    private static int[][] chessBoard;

    private static int N;
    private static int M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;

        chessBoard = new int[N][M];

        for (int i = 0; i < N; i++) {
            String chess = br.readLine();

            for (int j = 0; j < M; j++) {

                if (chess.charAt(j) == 'W') {
                    chessBoard[i][j] = 1;
                } else {
                    chessBoard[i][j] = 0;
                }

            }
        }

        for (int i = 0; i < N; i++) {

            if (N - i < 8) {
                break;
            }

            for (int j = 0; j < M; j++) {

                if (M - j < 8) {
                    break;
                }

                int reColorCount = getReColorCount(i, j);
//                System.out.println("i + j + reColorCount = " + i + " " + j + " " + reColorCount);
                if (reColorCount < min) {
                    min = reColorCount;
                }
            }

        }

        System.out.println(min);
    }

    private static int getReColorCount(int a, int b) {

        int count = 0;

//        chessBoard[0]

        int[][] clone = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                clone[i][j] = chessBoard[i + a][j + b];
            }
        }

          for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {

                if (i > 0 && clone[i][j] == 1 && clone[i - 1][j] == 1) {
                    clone[i][j] = 0;
                    count++;
                } else if (i > 0 && clone[i][j] == 0 && clone[i - 1][j] == 0) {
                    clone[i][j] = 1;
                    count++;
                }

                if (j > 0 && clone[i][j] == 1 && clone[i][j -1] == 1) {
                    clone[i][j] = 0;
                    count++;
                } else if (j > 0 && clone[i][j] == 0 && clone[i][j -1] == 0) {
                    clone[i][j] = 1;
                    count++;
                }

            }

        }

        return count > 32 ? 64-count : count;

    }

}
