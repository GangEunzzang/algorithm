import java.util.*;

public class Main {

    static ArrayList<Integer>[] connections;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        connections = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for(int i = 1 ; i <= n ; i ++) {
            connections[i] = new ArrayList<Integer>();
        }

        for(int i = 0 ; i < m ; i ++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            connections[x].add(y);
            connections[y].add(x);
        }

        for(int i = 1 ; i <= n ; i ++) {
            Collections.sort(connections[i]);
        }
        

        dfs(v);
        Arrays.fill(visited, false);
        System.out.println();
        bfs(v);
    }

    public static void dfs(int Node) {
        System.out.print(Node + " ");
        visited[Node] = true;
        for(int i : connections[Node]) {
            if(visited[i] == false) {
                dfs(i);
            }
        }
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(v);
        visited[v] = true;

        while(!queue.isEmpty()) {
            int Node = queue.poll();
            System.out.print(Node + " ");
            for(int i : connections[Node]) {
                if(visited[i] == false) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}