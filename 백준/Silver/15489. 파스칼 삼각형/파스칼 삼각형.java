import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int r,c,w,answer;
    static int[][] arr = new int[31][31];
    
    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        r = toInt(st.nextToken());
        c = toInt(st.nextToken());
        w = toInt(st.nextToken());

        for (int i = 1; i < 31; i++) {
            arr[i][1] = 1;
            for (int j = 2; j <= i; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }

        int idx = 1;
        for (int i = r; i < r + w; i++) {
            for (int j = c; j < c + idx; j++) {
                answer += arr[i][j];
            }
            idx ++;
        }

        System.out.println(answer);


    }

    private static int toInt(String val) {
        return Integer.parseInt(val);
    }
}