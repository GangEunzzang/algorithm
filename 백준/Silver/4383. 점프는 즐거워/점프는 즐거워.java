import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s;
        first:
        while ((s = br.readLine()) != null) {

            StringTokenizer st = new StringTokenizer(s);
            int N = Integer.parseInt(st.nextToken());

            if (N == 1) {
                sb.append("Jolly").append("\n");
                continue;
            }

            boolean[] checked = new boolean[N];

            int lastNum = Integer.parseInt(st.nextToken());

            for (int i = 0; i < N - 1; i++) {
                int nowNum = Integer.parseInt(st.nextToken());
                int abs = Math.abs(nowNum - lastNum);
                lastNum = nowNum;
                
                if (abs >= N || checked[abs]) {
                    sb.append("Not jolly").append("\n");
                    continue first;
                }
                checked[abs] = true;
            }

            sb.append("Jolly").append("\n");
        }

        System.out.println(sb);

    }

}