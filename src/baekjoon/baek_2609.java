package src.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class baek_2609 {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int one = Integer.parseInt(st.nextToken());
        int two = Integer.parseInt(st.nextToken());
        
        int hid = hid(one, two);
        
        System.out.println(hid);
        System.out.println((one*two) / hid);
    }
    
    public static int hid(int one, int two) {
        int temp = one % two;
        one = two;
        two = temp;
        
        if(two == 0) return one;
        if(one == two) return one;
        return hid(one, two);
    }
}
