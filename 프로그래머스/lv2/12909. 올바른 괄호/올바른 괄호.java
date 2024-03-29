import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(1);
                continue;
            }

            if (stack.empty()) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.empty();
    }
}