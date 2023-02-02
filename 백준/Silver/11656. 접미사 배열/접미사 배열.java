import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String N = br.readLine();
        
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < N.length(); i++ ) {
            String substring = N.substring(i, N.length());
          list.add(substring);
        }
        
        list.stream().sorted().forEach(System.out::println);
        
    }
    
}