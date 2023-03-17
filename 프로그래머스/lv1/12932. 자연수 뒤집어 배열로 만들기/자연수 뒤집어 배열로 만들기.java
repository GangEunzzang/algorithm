class Solution {
    public int[] solution(long n) {
        
        String number = String.valueOf(n);

        int[] answer = new int[number.length()];
        
        for (int i = number.length() -1; i >= 0; i--){
            answer[number.length() - i - 1 ] = number.charAt(i) - '0';
        }             
        return answer;
    }
}