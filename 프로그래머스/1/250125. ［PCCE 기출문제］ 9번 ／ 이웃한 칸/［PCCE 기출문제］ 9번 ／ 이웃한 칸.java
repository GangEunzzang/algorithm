class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;

        int[] moveX = {-1, 1, 0, 0};
        int[] moveY = {0, 0, -1, 1};

        for (int i=0; i<4; i++) {
            int mx = h + moveX[i];
            int my = w + moveY[i];
            if (mx < 0 || my < 0 || mx >= board.length || my >= board.length) continue;
            
            if (board[h][w].equals(board[mx][my])) answer++;
        }
       
        return answer;
    }
}
