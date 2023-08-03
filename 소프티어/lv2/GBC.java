import java.util.*;
import java.io.*;
import java.util.stream.IntStream;


public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] limitSpeedArr = new int[N][2];
        int[][] testSpeedArr = new int[M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            limitSpeedArr[i][0] = Integer.parseInt(st.nextToken());
            limitSpeedArr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            testSpeedArr[i][0] = Integer.parseInt(st.nextToken());
            testSpeedArr[i][1] = Integer.parseInt(st.nextToken());
        }

        int overSpeed = 0;
        int limitIndex = 0;

        for (int i = 0; i < N; i++) {
            for (int j = limitIndex; j < M; j++) {
                int testLength = testSpeedArr[i][0];
                int testSpeed = testSpeedArr[i][1];
                int limitLength = limitSpeedArr[j][0];
                int limitSpeed = limitSpeedArr[j][1];

                overSpeed = Math.max(testSpeed - limitSpeed, overSpeed);

                if (testLength < limitLength ){
                    limitSpeedArr[j][0] -= testSpeedArr[i][0];
                    break;
                }

                if (testLength > limitLength) {
                    testSpeedArr[i][0] -= limitSpeedArr[j][0];
                    limitIndex++;
                }

                if (testLength == limitLength) {
                    limitIndex++;
                    break;
                }
            }
        }

        System.out.println(overSpeed);

    }



}