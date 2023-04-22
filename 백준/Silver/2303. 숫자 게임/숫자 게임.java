import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        int[][] indexing = {
                {0,1,2}, {0,1,3}, {0,1,4},
                {0,2,3}, {0,2,4}, {0,3,4},
                {1,2,3}, {1,2,4}, {1,3,4},
                {2,3,4}
        };


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] cardArr = new int[N][5];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                cardArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int entryMax = (cardArr[0][0] + cardArr[0][1] + cardArr[0][2]) % 10;
        int maxNumber = 1;

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < 10; j++) {
                int value = (cardArr[i][indexing[j][0]] + cardArr[i][indexing[j][1]] + cardArr[i][indexing[j][2]]) % 10;

                if (value == entryMax) {
                    maxNumber = Math.max(maxNumber, i + 1);
                    continue;
                }

                if (value > entryMax) {
                    entryMax = value;
                    maxNumber = i + 1;
                }
            }
        }

        System.out.println(maxNumber);

    }
}