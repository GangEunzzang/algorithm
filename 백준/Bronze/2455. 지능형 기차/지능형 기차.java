import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int max = 0;
        int numOfGuest = 0;
        
        StringTokenizer st;

        for (int i = 0; i < 4; i++ ) {
            st = new StringTokenizer(br.readLine());
            int off = Integer.parseInt(st.nextToken());
            int rider = Integer.parseInt(st.nextToken());

            numOfGuest = numOfGuest - off + rider;

            if (numOfGuest > max) {
                max = numOfGuest;
            }

        }

        System.out.println(max);
    }
}