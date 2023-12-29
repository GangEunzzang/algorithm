import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    
    int N;
    List<List<Integer>> roadList = new ArrayList<>();
    boolean[] visited;
    int destination;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        this.N = n;
        this.destination = destination;
        
        for (int i = 0; i <= N; i++) {
            roadList.add(new ArrayList());
        }

        for (int[] road : roads) {
            roadList.get(road[0]).add(road[1]);
            roadList.get(road[1]).add(road[0]);
        }
        
        int[] answer = new int[sources.length];

        for (int i = 0; i < sources.length; i++) {
            answer[i] = bfs(sources[i]);
        }
        
        return answer;
    }

    int bfs(int start) {
        visited = new boolean[N + 1];

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.point == destination) {
                return node.count;
            }

            for (Integer nxtNode : roadList.get(node.point)) {
                if (visited[nxtNode]) continue;
                visited[nxtNode] =  true;
                q.add(new Node(nxtNode, node.count + 1));
            }
        }
        
        return -1;
    }
    
    class Node {
        int point;
        int count;
        public Node(int point, int count) {
            this.point = point;
            this.count = count;
        }
    }
}