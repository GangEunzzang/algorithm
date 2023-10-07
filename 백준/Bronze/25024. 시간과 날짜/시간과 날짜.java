import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static List<Integer> maxDayByMonth = List.of(0,31,29,31,30,31,30,31,31,30,31,30,31);


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            boolean isTime = timeCheck(x, y);
            boolean isDate = dateCheck(x, y);

            sb.append(isTime ? "Yes " : "No ");
            sb.append(isDate ? "Yes" : "No").append("\n");

        }

        System.out.println(sb);

    }


    private static boolean timeCheck(int x, int y) {
        return x <= 23 && y <= 59;
    }

    private static boolean dateCheck(int x, int y) {
        if (x > 12 || y > 31 || y < 1) return false;
        return y <= maxDayByMonth.get(x);
    }
}


