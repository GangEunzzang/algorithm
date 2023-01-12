package baekjoon;

import java.util.*;
import java.io.*;

class baek_2231 {
  public static void main(String[] args) throws IOException {

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    final int value = N;

    int result = 0 ;

    for (int i = N; i >=1; i --) {

      int num = 0;

      int check = i;

      while(true) {
        if(check < 1) {
          break;
        }

        num += check % 10;
        check = check / 10;
      }

      if ( i + num == value) {
        result = i;
      }
    }

    System.out.println(result);
    
  }
}
