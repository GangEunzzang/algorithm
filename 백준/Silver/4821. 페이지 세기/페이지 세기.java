import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            int sum = 0;
            boolean[] paper = new boolean[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine(), ",");

            while (st.hasMoreTokens()) {
                String pages = st.nextToken();

                if (pages.contains("-")) {
                    StringTokenizer st2 = new StringTokenizer(pages, "-");
                    int low = Integer.parseInt(st2.nextToken());
                    int high = Integer.parseInt(st2.nextToken());

                    if (low > high) continue;
                    if (high > N) high = N;

                    for (int i = low; i <= high; i++) {
                        if(paper[i]) continue;
                        paper[i] = true;
                        sum++;
                    }
                } else {
                    int page = Integer.parseInt(pages);
                    if (page > N) continue;

                    if (!paper[page]) {
                        paper[page] = true;
                        sum++;
                    }
                }
            }
            sb.append(sum).append("\n");

        }
        System.out.println(sb);

    }
}