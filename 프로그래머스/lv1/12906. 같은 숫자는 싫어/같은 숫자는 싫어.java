import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Deque<Integer> queue = new LinkedList();
        
        for (int num : arr) {
            
            if(queue.isEmpty()) {
                queue.add(num);
                continue;
            } 
            
            if (num == queue.peekLast()) {
                continue;
            }
            
            queue.add(num);
                    
        }
        
        int[] answer = new int[queue.size()];
        
        int i = 0;
        
        while (!queue.isEmpty()) {
            answer[i] = queue.poll();
            i++;
        }
            
        return answer;
    }
}