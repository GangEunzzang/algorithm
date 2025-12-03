import java.io.*;
import java.util.*;

public class Main {
    static final int[] COLORS = {1, 2, 3};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());

        // 미리 인접한 고정 색이 같은지 체크
        for (int i = 0; i < N - 1; i++) {
            if (a[i] != 0 && a[i] == a[i + 1]) {
                System.out.println(-1);
                return;
            }
        }

        // 0 구간 하나씩 채우기
        int i = 0;
        while (i < N) {
            if (a[i] != 0) {
                i++;
                continue;
            }

            // 0 구간 시작
            int start = i;
            while (i < N && a[i] == 0) i++;
            int end = i - 1; // 구간: [start, end]

            int leftColor = (start - 1 >= 0) ? a[start - 1] : 0;
            int rightColor = (end + 1 < N) ? a[end + 1] : 0;

            // 시작 색 후보 3개를 시도
            boolean ok = false;
            for (int s : COLORS) {
                if (s == leftColor) continue; // 왼쪽과 같은 색은 불가

                // 임시로 채워보기
                int prev = s;
                boolean valid = true;

                // 첫 자리
                a[start] = s;

                for (int idx = start + 1; idx <= end; idx++) {
                    // prev와 다른 색 아무거나
                    for (int c : COLORS) {
                        if (c != prev) {
                            a[idx] = c;
                            prev = c;
                            break;
                        }
                    }
                }

                // 오른쪽 충돌 검사
                if (rightColor != 0 && a[end] == rightColor)
                    valid = false;

                if (valid) {
                    ok = true;
                    break;
                }
            }

            if (!ok) {
                System.out.println(-1);
                return;
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int x : a) sb.append(x).append(' ');
        System.out.println(sb.toString());
    }
}
