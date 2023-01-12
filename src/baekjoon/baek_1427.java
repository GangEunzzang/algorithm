package baekjoon;

import java.util.*;
import java.io.*;

class baek_1427 {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String s = br.readLine();

    char[] arr = new char[s.length()];

    for (int i = 0; i < arr.length; i++ ) {
      arr[i] = s.charAt(i);
    }

    for (int i = 0; i < arr.length; i++ ) {

      for (int j = 0; j < arr.length; j++ ) {

        if (arr[i] > arr[j]) {

          char temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }

    StringBuilder sb = new StringBuilder();

    for(int i = 0; i <arr.length; i++) {
      sb.append(arr[i]);
    }

    System.out.println(sb);
    
  }
}
