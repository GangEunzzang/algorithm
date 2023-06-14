import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Node> stack = new Stack<>();
            
        int sum = 0;
        
        while (N-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int isProblem = Integer.parseInt(st.nextToken());

            if (isProblem == 1) {
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());

                if (time > 1) stack.add(new Node(time - 1, score));
                if (time < 2) sum += score;

                continue;
            }
            
            if (!stack.isEmpty()) {
                Node node = stack.pop();
                if(node.time > 1) stack.push(new Node(node.time - 1, node.score));
                if(node.time < 2) sum += node.score;
            }
        }
        System.out.println(sum);
        

    }

    static class Node {
        int time;
        int score;

        Node(int time, int score) {
            this.time = time;
            this.score = score;
        }
    }
    


}
