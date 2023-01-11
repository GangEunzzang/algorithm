import java.io.*;
import java.util.StringTokenizer;

public class Main {
  
    public static void main(String[] args) throws IOException {

      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      StringBuilder sb = new StringBuilder();
      StringTokenizer st ;

      int bae = 0;
      int deung = 0;
      
      for (int i = 0 ; i < 3; i++) {
        String a = br.readLine().replace(" ", "");

        
        for(int j = 0; j < 4; j++) {
          
          if (a.charAt(j) == '0') {
            bae++;
          }
        }

        switch(bae) {
          case 0:
            sb.append("E");
            break;
          case 1: 
            sb.append("A");
            break;
          case 2:
            sb.append("B");
            break;
          case 3:
            sb.append("C");
            break;
          case 4:
            sb.append("D");
            break;

        }

        sb.append("\n");
        bae = 0;
      }

      System.out.println(sb);
    }

}
