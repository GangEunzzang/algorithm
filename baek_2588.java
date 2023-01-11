import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int A = Integer.parseInt(br.readLine());
    String B = br.readLine();

    StringBuilder sb = new StringBuilder();

    sb.append(A * Character.getNumericValue(B.charAt(2)) + "\n");
    sb.append(A * Character.getNumericValue(B.charAt(1)) + "\n");
    sb.append(A * Character.getNumericValue(B.charAt(0)) + "\n");
    sb.append(A * Integer.parseInt(B));

    System.out.print(sb);
      
    }
}
