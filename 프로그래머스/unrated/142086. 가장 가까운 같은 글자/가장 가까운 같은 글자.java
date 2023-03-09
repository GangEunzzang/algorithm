class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
                
            char charAt = s.charAt(i);
            int num = -1;
            
            for (int j = 0; j < i; j++) {
                if (charAt == s.charAt(j)) {
                    num = i-j;
                }
            }

            answer[i] = num;
        }
        
        return answer;
    }
}