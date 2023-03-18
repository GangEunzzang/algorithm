class Solution {
    public int solution(int num) {
        
        int count = 0;
        long check = (long) num;
        
        while(check != 1) {
            
            if (count > 500) {
                return -1;
            }
            
            if(check % 2 == 0) {
                check = check / 2;
                count ++;
            } else {
                check = check * 3 + 1;
                count ++;
            }
        }
        return count;
    }
}