import java.util.Stack;

class Solution {

    private int answer;

    public int solution(String s) {
        StringBuilder sb = new StringBuilder(s);
        int T = s.length();

        while (T-- > 0) {
            char c = sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(c);
            check(sb.toString());
        }

        return answer;
    }

    private void check(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) return;

                switch (stack.peek()) {
                    case '[' :
                        if (c == ']') stack.pop();
                        else stack.add(c);
                        break;
                    case '{' :
                        if (c == '}') stack.pop();
                        else stack.add(c);
                        break;
                    case '(' :
                        if (c == ')') stack.pop();
                        else stack.add(c);
                        break;
                }
            }
        }
        if (stack.isEmpty()) {
            answer++;
        }

    }
}