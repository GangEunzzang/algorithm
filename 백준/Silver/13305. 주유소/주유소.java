import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] distance = new int[N - 1];
        int[] price = new int[N - 1];

        long count = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }


        int nowPrice = price[0];
        count += nowPrice * distance[0];

        /**
         * 2가지를 고려해야함
         *  1. 현재 주유소에서 꼭 기름을 넣어야 하는지 ?
         *  2. 내가 지금 기름을 다음 거리까지 넣어줘도 여기서 넣는게 더 싼지
         *  3. 위에 두개를 구현해줘야함
         */

        for (int i = 1; i < N - 1; i++) {

            if (price[i] <= nowPrice) {
                nowPrice = price[i];
            }
            count += (long) nowPrice * distance[i];

        }
        System.out.println(count);
    }
}