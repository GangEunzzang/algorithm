import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {

        Stack<Integer> stack = new Stack<>();
        int count = 0;


        for (int move : moves) {

            for (int i = 0; i < board.length; i++) {

                int[] ints = board[i];
                int val = ints[move - 1];
                
                if (val == 0) continue;

                ints[move-1] = 0;

                if (stack.size() > 0 && stack.peek() == val) {
                    stack.pop();
                    count += 2;
                } else {
                    stack.push(val);
                }
                break;
            }
        }
        return count;
    }
}