import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 강의실번호, 종료시간
        Map<Integer, Integer> roomMap = new HashMap<>();

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int roomNumber = Integer.parseInt(st.nextToken());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            Integer beforeEndTime = roomMap.getOrDefault(roomNumber, 0);

            if (beforeEndTime == 0 || startTime >= beforeEndTime) {
                sb.append("YES");
                roomMap.put(roomNumber, endTime);
            } else {
                sb.append("NO");
            }

            sb.append("\n");
        }

        System.out.println(sb);

    }
}