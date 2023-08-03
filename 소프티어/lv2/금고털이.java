import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 가격이 높은순으로 정렬
        Arrays.sort(arr, ((o1, o2) -> o2[1] - o1[1]));

        int answer = 0;
        int totalWeight = 0;

        for (int i = 0; i < N; i++) {
            int weight = arr[i][0];
            int price = arr[i][1];

            if (totalWeight + weight <= W) {
                totalWeight += weight;
                answer += price * weight;
            } else {
                answer += price * (W - totalWeight);
                break;
            }
        }

        System.out.println(answer);


    }
}