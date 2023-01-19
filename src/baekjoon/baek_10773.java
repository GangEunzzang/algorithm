package baekjoon;

import java.io.*;
import java.util.*;

public class baek_10773 {
    
    public static void main(String[] args) throws IOException {
        
        int sum = 0;
        Stack stack = new Stack();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < N; i++) {
            
            int num = Integer.parseInt(br.readLine());
            
            if (num != 0) {
                stack.push(num);
            }
            
            if (num == 0) {
                stack.pop();
            }
        }
        
        while (!stack.empty()) {
            sum += (int) stack.peek();
            stack.pop();
        }
        
        System.out.println(sum);
    }
}
