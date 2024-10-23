import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static boolean[][] visited = new boolean[6][6];
    static int lastX, lastY, firstX, firstY;

    public static void main(String[] args) throws IOException {
        String[] split = br.readLine().split("");
        lastX = split[0].charAt(0) - 'A';
        lastY = toInt(split[1]) - 1;
        firstX = lastX;
        firstY = lastY;
        visited[lastX][lastY] = true;

        int T = 35;

        while (T-- > 0) {
            split = br.readLine().split("");
            int x = split[0].charAt(0) - 'A';
            int y = toInt(split[1])  - 1;
            if (visited[x][y]) {
                System.out.println("Invalid");
                return;
            }

            visited[x][y] = true;
            if (!canMove(x, y, lastX, lastY)) {
                System.out.println("Invalid");
                return;
            }
            lastX = x;
            lastY = y;
        }

        System.out.println(canMove(lastX, lastY, firstX, firstY) ? "Valid" : "Invalid");
    }

    private static boolean canMove(int x, int y, int lastX, int lastY) {
        if (Math.abs(lastX - x) == 2 && Math.abs(lastY - y) == 1) {
            return true;
        }

        if (Math.abs(lastX - x) == 1 && Math.abs(lastY - y) == 2) {
            return true;
        }

        return false;
    }



    static int toInt(String s) {
        return Integer.parseInt(s);
    }

}
