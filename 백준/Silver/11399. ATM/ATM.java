import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int[] people = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++ ) {
            people[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++ ) {

            for(int j = i+1; j < N; j++) {
                if (people[i] > people[j]) {
                    int temp = people[i];
                    people[i] = people[j];
                    people[j] = temp;
                }
            }
        }
        
        for (int i = 0; i < N; i ++) {
            for (int j = 0; j <= i; j++){
                sum += people[j];
            }
        }

        System.out.println(sum);

    }
}