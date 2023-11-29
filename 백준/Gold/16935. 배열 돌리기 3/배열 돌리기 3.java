import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N; // 세로
    static int M; // 가로
    static int R; // 연산의 수
    static int[][] map;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (R-- > 0) {
            int check = Integer.parseInt(st.nextToken());

            switch (check) {
                case 1: one();break;
                case 2: two();break;
                case 3: three();break;
                case 4: four();break;
                case 5: five();break;
                case 6: six();break;
            }

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }




    private static void one() {
        int up = 0;
        int down = N - 1;

        for (int i = 0; i < N / 2; i++) {
            int[] temp = map[up].clone();
            map[up++] = map[down].clone();
            map[down--] = temp;
        }
    }

    private static void two() {
        int left = 0;
        int right = M - 1;

        for (int i = 0; i < M / 2; i++) {
            int[] temp = new int[N];

            for (int j = 0; j < N; j++) {
                temp[j] = map[j][i];
            }

            for (int j = 0; j < N; j++) {
                map[j][left] = map[j][right];
                map[j][right] = temp[j];
            }

            left++;
            right--;
        }
    }

    private static void three() {

        int[][] changeMap = new int[M][N];

        for (int i = 0; i < M; i++) {
            int[] tmp = new int[N];
            for (int j = N - 1; j >= 0; j--) {
                tmp[N - j - 1] = map[j][i];
            }

            changeMap[i] = tmp.clone();
        }

        int tmp = N;
        N = M;
        M = tmp;

        map = changeMap;
    }

    private static void four() {
        int[][] changeMap = new int[M][N];

        for (int i = M - 1; i >= 0; i--) {
            int[] tmp = new int[N];
            for (int j = 0; j < N; j++) {
                tmp[j] = map[j][i];
            }

            changeMap[M - i - 1] = tmp.clone();
        }

        int tmp = N;
        N = M;
        M = tmp;

        map = changeMap;
    }

    private static void five() {
        int divN = N / 2;
        int divM = M / 2;

        int[][] divOne = getDivideArray(0, divN, 0, divM);
        int[][] divTwo = getDivideArray(0, divN, divM, M);
        int[][] divThree = getDivideArray(divN, N, divM, M);
        int[][] divFour = getDivideArray(divN, N, 0, divM);

        // 4 - 1
        // 3 - 2  위치

        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                map[i][j] = divFour[i][j];
                map[i][j + divM] = divOne[i][j];
                map[i + divN][j] = divThree[i][j];
                map[i + divN][j + divM] = divTwo[i][j];
            }
        }
    }

    private static void six() {
        int divN = N / 2;
        int divM = M / 2;

        // 2 - 3
        // 1 - 4    위치
        int[][] divOne = getDivideArray(0, divN, 0, divM);
        int[][] divTwo = getDivideArray(0, divN, divM, M);
        int[][] divThree = getDivideArray(divN, N, divM, M);
        int[][] divFour = getDivideArray(divN, N, 0, divM);

        for (int i = 0; i < N/2; i++) {
            for (int j = 0; j < M/2; j++) {
                map[i][j] = divTwo[i][j];
                map[i][j + divM] = divThree[i][j];
                map[i + divN][j] = divOne[i][j];
                map[i + divN][j + divM] = divFour[i][j];
            }
        }
    }

    private static int[][] getDivideArray(int startN, int endN, int startM, int endM) {
        int divN = N / 2;
        int divM = M / 2;
        int tmp[][] = new int[divN][divM];

        int idx = 0;
        for (int i = startN; i < endN; i++) {
            List<Integer> tmpList = new ArrayList<>();
            for (int j = startM; j < endM; j++) {
                tmpList.add(map[i][j]);
            }
            tmp[idx++] = tmpList.stream().mapToInt(Integer::intValue).toArray();
        }

        return tmp;
    }

}