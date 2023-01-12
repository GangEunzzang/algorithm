package baekjoon;

import java.util.*;
import java.io.*;

class baek_7568 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    int[][] array = new int[N][2];

    for (int i = 0; i < N; i++ ) {

      StringTokenizer st = new StringTokenizer(br.readLine());

      int X = Integer.parseInt(st.nextToken());
      int Y = Integer.parseInt(st.nextToken());

      array[i][0] = X;
      array[i][1] = Y;
    }

    for (int i = 0; i < N; i++ ) {

      int count = 1;

      for (int j = 0; j < N; j++) {

        int X = array[i][0];
        int Y = array[i][1];

        int otherX = array[j][0];
        int otherY = array[j][1];

        if ( X < otherX && Y < otherY) {
          count++;
        }
      }

      sb.append(count + "\n");
    }

    System.out.println(sb);
  }
}
