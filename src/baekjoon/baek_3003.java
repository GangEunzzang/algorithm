package src.baekjoon;

import java.io.*;
import java.util.*;

public class baek_3003 {
    
    public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      StringTokenizer st = new StringTokenizer(br.readLine());

      StringBuilder sb = new StringBuilder();

      sb.append(1 - Integer.parseInt(st.nextToken()) + " ");
      sb.append(1 - Integer.parseInt(st.nextToken()) + " ");
      sb.append(2 - Integer.parseInt(st.nextToken()) + " ");
      sb.append(2 - Integer.parseInt(st.nextToken()) + " ");
      sb.append(2 - Integer.parseInt(st.nextToken()) + " ");
      sb.append(8 - Integer.parseInt(st.nextToken()) + " ");
      
      System.out.print(sb);

      
    }
}
