import java.io.*;
import java.util.*;

public class Main {

    private static int nowX, nowY, maxX, maxY, minX, minY;
    private static int[] moveX = {1, 0, -1, 0};
    private static int[] moveY = {0, -1, 0, 1};
    private static int direction; // 0 = 동, 1 = 남, 2 = 서, 3 = 북

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            initVariable();
            for (char command : br.readLine().toCharArray()) {
                moveByCommand(command);
            }
            sb.append((Math.abs(minX) + Math.abs(maxX)) * (Math.abs(minY) + Math.abs(maxY)) + "\n");
        }

        System.out.println(sb);

    }


    private static void moveByCommand(char command) {
        switch (command) {
            case 'F':
                nowX += moveX[direction];
                nowY += moveY[direction];
                break;

            case 'B':
                nowX -= moveX[direction];
                nowY -= moveY[direction];
                break;

            case 'L':
                if (direction == 0) direction = 3;
                else direction--;
                break;

            case 'R':
                if (direction == 3) direction = 0;
                else direction++;
                break;
        }

        minX = Math.min(minX, nowX);
        minY = Math.min(minY, nowY);
        maxX = Math.max(maxX, nowX);
        maxY = Math.max(maxY, nowY);

    }

    private static void initVariable() {
        nowX = 0;
        nowY = 0;
        maxX = 0;
        maxY = 0;
        minX = 0;
        minY = 0;
        direction = 0;
    }

}