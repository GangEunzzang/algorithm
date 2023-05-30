import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int [] dp = new int[n+1];

        for(int i=0; i<n; i++) {
            int k = scan.nextInt();
            dp[k] = dp[k-1]+1;
        }

        int max = Arrays.stream(dp).max().orElse(0);
        System.out.println(n-max);


    }
}