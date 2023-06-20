class Solution {

    public int solution(int[] cards) {
        
        int firstMax = 0;
        int secondMax = 0;
        boolean[] visited = new boolean[cards.length];
        
        for(int i = 0; i < cards.length; i++){
            int idx = cards[i] - 1;
            int count = 0;
            
            while(true) {
                if (visited[idx]) break;
        
                visited[idx] = true;
                count++;
                idx = cards[idx] - 1;
            }
        
            if (count > firstMax){
                secondMax = firstMax;
                firstMax = count;
            }  else if (count > secondMax) {
                secondMax = count;
            }
            
        }
        
        
        return firstMax * secondMax;
    }
    
}