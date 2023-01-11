import java.io.*;

public class Main {

  public static boolean primeArr[];
  
    public static void main(String[] args) throws IOException {

      char[][] charArr = new char[5][15];
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      StringBuilder sb = new StringBuilder();

      for(int i = 0; i < 5; i++) {

        String s = br.readLine();
        
        for(int j = 0; j <s.length(); j++) {
          charArr[i][j] = s.charAt(j);
        }
      }

      for (int i = 0; i < 15; i++) {

        for (int j = 0; j < 5; j++) {

          if (charArr[j][i] != '\u0000') {
            sb.append(charArr[j][i]);
          }
        }
      }
       System.out.println(sb);
    }

}
