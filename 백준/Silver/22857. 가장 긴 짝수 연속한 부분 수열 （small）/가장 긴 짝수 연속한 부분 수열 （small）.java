import java.io.*;
import java.util.StringTokenizer;

public class Main {

    private static int max, start, end, odd, even;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[S];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (arr[0] % 2 == 1) odd++;
        else even++;
        
        max = even;

        while (start <= end) {

            if(odd > N){
                if(arr[start] % 2 == 0) even--;
                else odd--;
                start++;
            } else {
                if (++end >= S) break;

                if(arr[end] % 2 == 0) even++;
                else odd++;

                max = Math.max(max, even);

            }

        }

        System.out.println(max);
    }
}