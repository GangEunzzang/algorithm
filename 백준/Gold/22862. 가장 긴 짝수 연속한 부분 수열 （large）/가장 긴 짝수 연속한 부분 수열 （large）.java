import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] arr = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num % 2 == 0;
        }

        int max = 0;
        int left = 0;
        int right = 0;
        int freeCount = 0;

        while (right < N) {
            // K를 사용할 수 있는 경우
            if (freeCount < K) {
                
                // 홀수면 카운트 증가
                if (!arr[right++]) freeCount++;
                max = Math.max(right - left - freeCount, max);

            } 
            
            // count를 사용할 수 없지만 짝수인 경우
            else if (arr[right]) {
                right++;
                max = Math.max(right - left - freeCount, max);
            } 
            
            // count도 사용할 수 없고 홀수인 경우
            else {
                if (!arr[left++]) freeCount--;
            }
        }

        System.out.println(max);

    }

}