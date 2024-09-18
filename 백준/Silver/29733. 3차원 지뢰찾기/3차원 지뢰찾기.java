import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] firstLine = br.readLine().split(" ");
        int R = Integer.parseInt(firstLine[0]);
        int C = Integer.parseInt(firstLine[1]);
        int H = Integer.parseInt(firstLine[2]);

        char[][][] cube = new char[H][R][C];

        for (int h = 0; h < H; h++) {
            for (int r = 0; r < R; r++) {
                String line = br.readLine();
                for (int c = 0; c < C; c++) {
                    cube[h][r][c] = line.charAt(c);
                }
            }
        }

        char[][][] result = new char[H][R][C];

        for (int h = 0; h < H; h++) {
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (cube[h][r][c] == '*') {
                        result[h][r][c] = '*';
                        continue;
                    }

                    int count = 0;
                    for (int dh = -1; dh <= 1; dh++) {
                        for (int dr = -1; dr <= 1; dr++) {
                            for (int dc = -1; dc <= 1; dc++) {
                                if (dh == 0 && dr == 0 && dc == 0) {
                                    continue;
                                }
                                int nh = h + dh;
                                int nr = r + dr;
                                int nc = c + dc;
                                if (nh >= 0 && nh < H && nr >= 0 && nr < R && nc >= 0 && nc < C) {
                                    if (cube[nh][nr][nc] == '*') {
                                        count++;
                                    }
                                }
                            }
                        }
                    }
                    result[h][r][c] = (char) ((count % 10) + '0');
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int h = 0; h < H; h++) {
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    sb.append(result[h][r][c]);
                }
                sb.append('\n');
            }
        }

        System.out.print(sb);
    }
}
