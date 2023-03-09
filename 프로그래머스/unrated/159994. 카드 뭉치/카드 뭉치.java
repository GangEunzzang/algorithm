import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Set<String> usedCards = new HashSet<>();
        Queue<String> card1Queue = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> card2Queue = new LinkedList<>(Arrays.asList(cards2));
        
        for (String s : goal) {
            if (usedCards.contains(s)) {  // 이미 사용한 카드인 경우
                return "No";
            }
            if (!card1Queue.isEmpty() && card1Queue.peek().equals(s)) {
                usedCards.add(s);
                card1Queue.poll();
            } else if (!card2Queue.isEmpty() && card2Queue.peek().equals(s)) {
                usedCards.add(s);
                card2Queue.poll();
            } else {  // 해당 단어를 사용할 수 없는 경우
                return "No";
            }
        }
        
        return "Yes";
    }
}
