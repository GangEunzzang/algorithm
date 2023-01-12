package src.baekjoon;

import java.util.Scanner;	// Scanner 클래스 호출

class baek_25305 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int k = sc.nextInt();

    int[] x = new int[N];

    for (int i = 0; i < x.length; i++) {
        x[i] = sc.nextInt();
    }
     
    for (int i = 0; i < x.length; i++) {
      
      for(int j = 0; j < x.length; j++) {

        if(x[i] > x[j]) {
          int temp = x[i];
          x[i] = x[j];
          x[j] = temp;
        }
      }
    }

    System.out.println(x[k-1]);
}
}
