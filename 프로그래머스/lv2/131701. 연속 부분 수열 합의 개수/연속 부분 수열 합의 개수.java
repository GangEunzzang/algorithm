import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    
    public int solution(int[] elements) {
        int[] newElements = new int[elements.length * 2];
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = newElements[i + elements.length] = elements[i];
        }
        
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                set.add(Arrays.stream(newElements, i, i + j).sum());
            }
        }
        
        return set.size();
    }


}