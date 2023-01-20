import java.io.*;
import java.util.*;

public class Main {

    public static Deque<Integer> queue = new LinkedList<>();
  
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++ ) {
          queue.add(i);
        }

      while (queue.size() > 1) {
        queue.poll();
        Integer num = queue.poll();
        queue.offerLast(num);
      }

      System.out.print(queue.peek());

       
    }
}