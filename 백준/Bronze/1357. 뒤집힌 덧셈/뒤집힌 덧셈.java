import java.util.*;
import java.io.*;

class Main {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    String X = st.nextToken();
    String Y = st.nextToken();

    StringBuilder sb = new StringBuilder();

    sb.append(X);
    sb.reverse();

    X = sb.toString();

    sb.setLength(0);

    sb.append(Y);
    sb.reverse();

    Y = sb.toString();

    sb.setLength(0);

    sb.append(Integer.parseInt(X) + Integer.parseInt(Y));

    sb.reverse();

    System.out.print(Integer.parseInt(sb.toString()));
    
  }
}