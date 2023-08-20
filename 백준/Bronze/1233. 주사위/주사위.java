import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
       // 123 12 123 완전 탐색 문제 -> for 문 세 개로 가능하다
        String[] nums = br.readLine().split(" ");
        int s1 = Integer.parseInt(nums[0]);
        int s2 = Integer.parseInt(nums[1]);
        int s3 = Integer.parseInt(nums[2]);
        int[] result = new int[s1 + s2 + s3 + 13];
        Arrays.fill(result, 100);
        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                for(int k = 1; k <= s3; k++){
                    result[i + j + k]--;
                }
            }
        }
        int min = 100;
        int index = -1;
        for(int n = 0; n < result.length; n++){
            if(min > result[n]){
                min = result[n];
                index = n;
            }
        }

        System.out.println(index);

    }
}