import java.io.*;
import java.util.StringTokenizer;

public class Main {

  public static boolean primeArr[];
  
    public static void main(String[] args) throws IOException {

      int min = 0;
      int sum = 0;
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int M = Integer.parseInt(br.readLine()); 
      int N = Integer.parseInt(br.readLine());

      primeArr = new boolean[N + 1];
      checkPrime(N);
      
      for (int i = M; i <= N; i++) {

        if (primeArr[i] == false) {
          sum += i;

          if (min == 0) {
            min = i;
          }
        }
      }

      if (sum != 0) {
        System.out.println(sum);
        System.out.println(min);
      }

      if (sum == 0) {
        System.out.println(-1);
      }

    }


  public static void checkPrime(int N) {

    primeArr[0] = primeArr[1] = true;


    for (int i = 2; i < Math.sqrt(N); i++) {

      if (primeArr[i] == true) {
        continue;
      }

      for (int j = i * i; j < primeArr.length; j += i) {

        primeArr[j] = true;
      }
    
    }
  }
}
