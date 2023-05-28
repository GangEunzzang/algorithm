class Solution {
    private boolean[][][] visited = new boolean[11][11][4];
    private final int[] movedOfUp = {-1, 0};
    private final int[] movedOfDown = {1, 0};
    private final int[] movedOfLeft = {0, -1};
    private final int[] movedOfRight = {0, 1};
    private int nowX = 5;
    private int nowY = 5;

    public int solution(String dirs) {
        char[] array = dirs.toCharArray();
        int answer = 0;

        for (char command : array) {
            int[] moveByCommand = moveByCommand(command);
            boolean canMove = isChecked(moveByCommand[0], moveByCommand[1]);
            if(!canMove) continue;

            int nx = moveByCommand[0];
            int ny = moveByCommand[1];
            int direction = directionOfCommand(command);

            if (!visited[nx][ny][direction] && !visited[nowX][nowY][3-direction]) {
                visited[nx][ny][direction] = true;
                visited[nowX][nowY][3-direction] = true;
                answer++;
            }

            nowX = nx;
            nowY = ny;

        }
        return answer;
    }


    private boolean isChecked(int x, int y) {
        return x >= 0 && y >= 0 && x <= 10 && y <= 10;
    }

    private int[] moveByCommand(char command) {
        int[] arr = new int[2];

        switch (command) {
            case 'U':
                arr[0] = nowX + movedOfUp[0];
                arr[1] = nowY + movedOfUp[1];
                break;
            case 'D':
                arr[0] = nowX + movedOfDown[0];
                arr[1] = nowY + movedOfDown[1];
                break;
            case 'R':
                arr[0] = nowX + movedOfRight[0];
                arr[1] = nowY + movedOfRight[1];
                break;
            case 'L':
                arr[0] = nowX + movedOfLeft[0];
                arr[1] = nowY + movedOfLeft[1];
                break;
        }
        return arr;
    }

    private int directionOfCommand(char command) {
        switch (command) {
            case 'U' : return 0;
            case 'L' : return 1;
            case 'R' : return 2;
            case 'D' : return 3;
        }
        throw new RuntimeException("이상한 값 들어옴");
    }


}