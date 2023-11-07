import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    private static int X;
    private static int Y;
    private static int[][] arr;
    private static int[] moveX = {0, 0, 1, -1};
    private static int[] moveY = {1, -1, 0, 0};
    private static List<Robot> robots = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        arr = new int[X + 1][Y + 1];

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 로봇 개수
        int M = Integer.parseInt(st.nextToken()); // 명령 개수

        int robotCount = 1;

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);
            robots.add(new Robot(X - x + 1, y, direction));
            arr[X - x + 1][y] = robotCount++;
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int robotNum = Integer.parseInt(st.nextToken()) - 1;
            char command = st.nextToken().charAt(0);
            int repeatCount = Integer.parseInt(st.nextToken());

            Robot robot = robots.get(robotNum);

            switch (command) {
                case 'L':
                    turnLeft(robot, repeatCount);
                    break;
                case 'R':
                    turnRight(robot, repeatCount);
                    break;
                case 'F':
                move(robotNum, repeatCount);
            }
        }

        System.out.println("OK");
    }

    private static void move(int robotNum, int repeatCount) {
        Robot robot = robots.get(robotNum);
        char direction = robot.direction;

        while (repeatCount-- > 0) {
            int mx = 0;
            int my = 0;

            if (direction == 'E') {
                mx = robot.x + moveX[0];
                my = robot.y + moveY[0];
            } else if (direction == 'W') {
                mx = robot.x + moveX[1];
                my = robot.y + moveY[1];
            } else if (direction == 'S') {
                mx = robot.x + moveX[2];
                my = robot.y + moveY[2];
            } else if (direction == 'N') {
                mx = robot.x + moveX[3];
                my = robot.y + moveY[3];
            }

            // 벽을 부딪히는 경우
            if (mx < 1 || my < 1 || mx > X || my > Y) {
                System.out.println("Robot " + (robotNum + 1) + " crashes into the wall");
                System.exit(0);
            }

            // 이동하려는 위치에 로봇이 존재하는 경우
            if (arr[mx][my] >= 1) {
                System.out.println("Robot " + (robotNum + 1) + " crashes into robot " + arr[mx][my]);
                System.exit(0);
            }

            arr[robot.x][robot.y] = 0;
            arr[mx][my] = robotNum + 1;

            robot.x = mx;
            robot.y = my;
        }

    }

    private static void turnLeft(Robot robot, int repeatCount) {
        while (repeatCount-- > 0) {
            char direction = robot.direction;

            switch (direction) {
                case 'N': robot.direction = 'W';
                    break;
                case 'E': robot.direction = 'N';
                    break;
                case 'S': robot.direction = 'E';
                    break;
                case 'W': robot.direction = 'S';
            }
        }
    }
    private static void turnRight(Robot robot, int repeatCount) {
        while (repeatCount-- > 0) {
            char direction = robot.direction;

            switch (direction) {
                case 'N': robot.direction = 'E';
                    break;
                case 'E': robot.direction = 'S';
                    break;
                case 'S': robot.direction = 'W';
                    break;
                case 'W': robot.direction = 'N';
            }
        }
    }

    private static class Robot {
        int x;
        int y;
        char direction;

        public Robot(int x, int y, char direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }


}