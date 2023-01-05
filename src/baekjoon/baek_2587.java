import java.util.Scanner;	// Scanner 클래스 호출

class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    int[] numArr = new int[5];
    int sum = 0;
    
    for (int i = 0; i < numArr.length; i ++) {
      numArr[i] = sc.nextInt();
      sum += numArr[i];
    }

    
    for (int i = 0; i < numArr.length; i++) {
      for (int j = 0; j < numArr.length; j++) {
        if (numArr[i] < numArr[j]) {
          int temp = numArr[i];
          numArr[i] = numArr[j];
          numArr[j] = temp;
        }
      }
    }
      System.out.println(sum/5);
      System.out.println(numArr[2]);
  }
}
