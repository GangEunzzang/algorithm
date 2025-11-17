class Solution {
    public int solution(int n, int w, int num) {
        int height = (n + w - 1) / w;  // 올림 계산을 명확하게
        int[][] grid = new int[height][w];
        
        Position targetPosition = fillGrid(grid, n, w, num);
        
        return countAbove(grid, targetPosition);
    }
    
    private Position fillGrid(int[][] grid, int totalNumbers, int width, int target) {
        int currentNumber = 1;
        Position targetPos = null;
        
        for (int row = grid.length - 1; row >= 0; row--) {
            boolean isOddRow = (grid.length - row) % 2 == 1;
            
            for (int col = 0; col < width; col++) {
                if (currentNumber > totalNumbers) break;
                
                int actualCol = isOddRow ? col : width - col - 1;
                grid[row][actualCol] = currentNumber;
                
                if (currentNumber == target) {
                    targetPos = new Position(row, actualCol);
                }
                currentNumber++;
            }
        }
        
        return targetPos;
    }
    
    private int countAbove(int[][] grid, Position pos) {
        int count = 0;
        
        for (int row = pos.row; row >= 0; row--) {
            int value = grid[row][pos.col];
            if (value == 0) break;
            count++;
        }
        
        return count;
    }
    
    private static class Position {
        final int row;
        final int col;
        
        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}