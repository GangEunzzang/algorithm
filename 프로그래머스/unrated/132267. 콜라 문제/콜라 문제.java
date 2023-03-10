
class Solution {
    public int solution(int a, int b, int n) {
        
        int answer = 0;
        
        while (n >= a) {
            int divide = n / a;
            n = n - (a * divide);
            answer += divide * b;
            n += divide * b;
        }
        
        return answer;
    }
}