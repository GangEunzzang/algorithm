import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] road = new int[101];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int roadIndex = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int length = Integer.parseInt(st.nextToken());
            int speedLimit = Integer.parseInt(st.nextToken());

            while (length-- > 0) {
                road[roadIndex++] = speedLimit;
            }
        }

        int maxViolationSpeed = 0;
        roadIndex = 1;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int length = Integer.parseInt(st.nextToken()) + roadIndex;
            int speed = Integer.parseInt(st.nextToken());

            for (int j = roadIndex; j < length; j++) {
                if (speed > road[j]) {
                    maxViolationSpeed = Math.max(speed - road[j], maxViolationSpeed);
                }
            }

            roadIndex = length;
        }

        System.out.println(maxViolationSpeed);

    }
}