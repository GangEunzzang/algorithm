import java.io.*;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      int T = Integer.parseInt(st.nextToken());

      StringBuilder sb = new StringBuilder();

      int[] arr = new int[10];

      for (int i = 0; i < T; i++) {

        st = new StringTokenizer(br.readLine());

        for ( int j = 0; j < 10; j ++ ) {
          arr[j] = Integer.parseInt(st.nextToken());
        }

        swapDesc(arr);
        sb.append(arr[2]).append("\n");
        
      }
      System.out.println(sb);
      
    }

  public static void swapDesc(int[] arr) {

    for (int i = 0; i < arr.length; i++) {

      for (int j = 0; j < arr.length; j++) {

        if (arr[i] > arr[j]) {

          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
      
    }
  }
     
}
