import javax.swing.*;
import java.io.*;
import java.util.*;


public class Main {

    static int INF = 1_000_000_000;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, A,B;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken());
        A = toInt(st.nextToken());
        B = toInt(st.nextToken());
        arr = new int[N][2];
        List<Pair> list = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = toInt(st.nextToken());
            int b = toInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;
            list.add(new Pair(i, a-b));
        }

        long result = 0;
        
        list.sort((Comparator.comparingInt(o -> o.diff)));
        while (A-- > 0) {
            result += arr[(list.remove(0).idx)][0];
        }

        list.sort(((o1, o2) -> o2.diff - o1.diff));
        while (B-- > 0) {
            result += arr[(list.remove(0).idx)][1];
        }

        System.out.println(result);

    }

    static int toInt(String val) {
        return Integer.parseInt(val);
    }

    static class Pair {
        int idx;
        int diff;

        public Pair(int idx, int diff) {
            this.idx = idx;
            this.diff = diff;
        }
    }

}




