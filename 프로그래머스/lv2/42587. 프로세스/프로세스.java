import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Node> q = new LinkedList<>();
        
        int order = 1;

        for (int i = 0; i < priorities.length; i++) {
            int priority = priorities[i];
            q.add(new Node(priority, i));
        }
        
        while (!q.isEmpty()) {
            boolean check = greaterThanCheck(q.peek().val, q);
            if (check) {
                q.add(q.poll());
            } else {
                Node node = q.poll();
                if (node.index == location) {
                    return order;
                }
                order++;
            }
        }
        return 0;
    }

    private static boolean greaterThanCheck(int num, Queue<Node> q) {
        return q.stream().anyMatch(i -> i.val > num);
    }
    
     class Node{
        int val;
        int index;

         public Node(int val, int index) {
             this.val = val;
             this.index = index;
         }
     }
}