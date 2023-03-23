import java.util.*;


class Solution {
    public int solution(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);

            if (!stack.empty() && stack.peek() == charAt)  {
                stack.pop();
            } else {
                stack.add(charAt);
            }
        }
        
        return stack.empty() ? 1 : 0;
    }
}