import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 칭호 종류
        int M = Integer.parseInt(st.nextToken()); // 캐릭터 개수
        StringBuilder sb = new StringBuilder();

        String[][] character = new String[N][2];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            character[i][0] = st.nextToken();
            character[i][1] = st.nextToken();
        }



        for (int i = 0; i < M; i++) {
            int power = Integer.parseInt(br.readLine());
            int left = 0;
            int right = N - 1;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (Integer.parseInt(character[mid][1]) < power) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sb.append(character[left][0]).append("\n");
        }

        System.out.println(sb);
    }


}

