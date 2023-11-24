import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken()); // 높이 (층수)
            int W = Integer.parseInt(st.nextToken()); // 길이 (호수 )
            int N = Integer.parseInt(st.nextToken()); // 몇번째 손님?

            int floor = 0;
            int width = 1;

            while (N-- > 0) {
                if (++floor > H) {
                    width++;
                    floor = 1;
                }
            }

            String widthString = width < 10 ? "0" + width : String.valueOf(width);
            sb.append(floor + widthString + "\n");
        }

        System.out.println(sb);
    }




}