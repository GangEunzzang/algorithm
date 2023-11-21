import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer> requiredMinMileageList = new ArrayList<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken()); // 신청 수
            int l = Integer.parseInt(st.nextToken()); // 수강 인원

            int[] arr = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::valueOf)
                    .sorted()
                    .toArray();
            
            if (l > p) {
                requiredMinMileageList.add(1);
                continue;
            }

            requiredMinMileageList.add(arr[p - l]);
        }

        Collections.sort(requiredMinMileageList);

        int answer = 0;

        for (Integer min : requiredMinMileageList) {
            if (m - min < 0) break;
            m -= min;
            answer++;
        }

        System.out.println(answer);
    }

}