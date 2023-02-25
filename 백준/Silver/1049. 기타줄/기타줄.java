import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int guitarPackage = Integer.MAX_VALUE;
        int guitarSingle = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pack = Integer.parseInt(st.nextToken());
            int single = Integer.parseInt(st.nextToken());

            if (pack < guitarPackage) {
                guitarPackage = pack;
            }

            if (single < guitarSingle) {
                guitarSingle = single;
            }
        }


        int divide = (N / 6) + 1;
        int answer = Integer.MAX_VALUE;

        while (divide >= 0) {

            int data = N;
            int sum = 0;

            sum += guitarPackage * divide;

            data = N - (6 * divide);
            if (data < 0) {
                if (sum < answer) {
                    answer = sum;
                }
                divide--;
                continue;
            }


            sum += guitarSingle * data;
            if (sum < answer) {
                answer = sum;
            }

            divide--;
        }
        System.out.println(answer);
    }

}
