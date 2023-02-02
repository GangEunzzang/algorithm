import java.io.*;
import java.util.*;

public class Main {
    
    public static Deque<Integer> deque = new LinkedList<>();
    public static StringBuilder sb  = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        for (int i = N; i >= 1; i-- ) {
            deque.push(i);
        }
        
        for (int i = 1; i <= N; i++ ) {
            pop();
            popAndLastPush();
        }
        
        System.out.print(sb);
        
    }
    
    public static void pop() {
        sb.append(deque.pop()).append(" ");
    }
    
    public static void popAndLastPush() {
        Integer poll = deque.poll();
        deque.addLast(poll);
    }
    
}