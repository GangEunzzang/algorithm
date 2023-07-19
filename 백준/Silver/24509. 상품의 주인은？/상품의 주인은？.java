import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] students;
    static boolean[] chk;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        students = new int[n + 1][4];
        chk = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++)
                students[idx][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < 4; i++)    // 국어, 영어, 수학, 과학과목을 훑어보기에 각각의 인덱스를 이용하여 최고점 학생을 탐색
            find(i);
    }

    public static void find(int idx) {
        int max = -1, ans = 0;
        for (int i = 1; i <= n; i++) {
            if (!chk[i] && students[i][idx] > max) {    // 상품을 가져가지 않은 학생이며, 점수가 높은 학생에게만 상품을 줌
                ans = i;
                max = students[i][idx];
            }
        }
        chk[ans] = true;    // 상품을 가져가는 학생을 체크
        System.out.print(ans + " ");
    }
}