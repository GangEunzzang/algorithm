class Solution {
    public static int solution(String s) {
        char x = s.charAt(0);
        int answer = 0;
        int mainCount = 1;
        int subCount = 0;

        for (int i = 1; i < s.length(); i++) {
            if (x == ' ') {
                x = s.charAt(i);
                continue;
            }
            if (x == s.charAt(i)) {
                mainCount++;
            }else{
                subCount++;
            }
            if (mainCount == subCount) {
                answer++;
                x = ' ';
                mainCount = 1;
                subCount = 0;
            }
        }
        if (x != ' ') {
            answer++;
        }

        return answer;
    }
}