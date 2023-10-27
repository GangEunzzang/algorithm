import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private int startX;
    private int startY;
    private int[] moveX = {-1, 1, 0, 0};
    private int[] moveY = {0, 0, -1, 1};
    private int[][] arr;
    private boolean[][] visited;
    private int min = Integer.MAX_VALUE;
    private int xLength;
    private int yLength;

    public int solution(String[] board) {

        arr = new int[board.length][board[0].length()];
        visited = new boolean[board.length][board[0].length()];
        xLength = arr.length;
        yLength = arr[0].length;

        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i].toCharArray();

            for (int j = 0; j < chars.length; j++) {
                char check = chars[j];
                switch (check) {
                    case 'R':
                        startX = i;
                        startY = j;
                        break;
                    case 'D':
                        arr[i][j] = 1;
                        break;
                    case 'G':
                        arr[i][j] = 2;
                        break;
                }
            }
        }

        bfs();
        
        return  min == Integer.MAX_VALUE ? -1 : min;
    }

    private void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(startX, startY, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (arr[node.x][node.y] == 2) {
                min = Math.min(min, node.count);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int x = node.x;
                int y = node.y;

                while (true) {

                    if (x < 0 || y < 0 || x >= xLength || y >= yLength || arr[x][y] == 1) {
                        x -= moveX[i];
                        y -= moveY[i];

                        if (!visited[x][y]) {
                            visited[x][y] = true;
                            q.add(new Node(x, y, node.count + 1));
                        }

                        break;
                    }

                    x += moveX[i];
                    y += moveY[i];

                }


            }
        }
    }

    private class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

}