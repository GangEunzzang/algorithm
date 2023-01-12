package baekjoon;

import java.util.*;
import java.io.*;

class baek_2798 {
  
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];

    int nearValue = Integer.MAX_VALUE;
    int check = 0;

    st = new StringTokenizer(br.readLine());

    for(int i = 0; i < N; i ++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    loop:
    for (int i = 0; i < N; i ++) {

      for (int j = i+1; j < N; j++) {

        for(int k = j+1; k < N; k++) {

          int num = arr[i] + arr[j] + arr[k];

          if (num == M) {
            System.out.println(num);
            check = 1;
            break loop;
          }

          if (num < M) {
            if((M - num) < nearValue) {
              nearValue = M - num;
            }
          }
        }
      }
    }

    if (check != 1) {
        System.out.print(M - nearValue);
    }
    
  }
}
