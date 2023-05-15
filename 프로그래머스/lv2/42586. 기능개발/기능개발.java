import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        Queue<Node> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        int day = 0;

        for (int i = 0; i < progresses.length; i++) {
            queue.add(new Node(progresses[i], speeds[i]));
        }

        while (!queue.isEmpty()) {
            Node node = queue.peek();
            int progress = node.progress;
            int speed = node.speed;

            if (progress + (speed * day) < 100) {
                day++;
                continue;
            }

            list.add(getCount(queue, day));
        }

        System.out.println(Arrays.toString(list.toArray()));
        
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int getCount(Queue<Node> queue, int day) {

        int count = 0;
        while (!queue.isEmpty()) {
            Node peek = queue.peek();
            int speed = peek.speed;
            int progress = peek.progress;

            if (progress + (speed * day) >= 100) {
                queue.poll();
                count++;
            } else {
                break;
            }
        }

        return count;
    }

    class Node {
        public int progress;
        public int speed;

        public Node(int progress, int speed) {
            this.progress = progress;
            this.speed = speed;
        }
    }

 
}

