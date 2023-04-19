import java.util.*;

class Solution {

    public int solution(int x, int y, int n) {
        Queue<Node> queue = new LinkedList<>();
        Set<Long> visited = new HashSet<>();

        queue.offer(new Node(x, 0));
        visited.add((long)x);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            long value = node.value;
            int count = node.count;

            if (value == y) {
                return count;
            }

            if (value + n <= y && !visited.contains(value + n)) {
                queue.offer(new Node(value + n, count + 1));
                visited.add(value + n);
            }

            if (value * 2 <= y && !visited.contains(value * 2)) {
                queue.offer(new Node(value * 2, count + 1));
                visited.add(value * 2);
            }

            if (value * 3 <= y && !visited.contains(value * 3)) {
                queue.offer(new Node(value * 3, count + 1));
                visited.add(value * 3);
            }
        }

        return -1;
    }

    static class Node {
        long value;
        int count;

        public Node(long value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}
