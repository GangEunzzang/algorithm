import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int M,N,K;

    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        st = new StringTokenizer(s);

        N = toInt(st.nextToken());
        M = toInt(st.nextToken());
        K = toInt(st.nextToken());

        int[] arr = new int[N];

        List<Integer> hiList = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            hiList.add( toInt(br.readLine()));
        }

        while (K-- > 0) {
            for (Integer i : hiList) {
                int left = (i - 1 + N) % N;
                int right = (i + 1) % N;
                arr[left]++;
                arr[right]++;
            }

            hiList.clear();

            for (int i = 0; i < N; i++) {
                if (arr[i] == 1) {
                    hiList.add(i);
                }
                arr[i] = 0;
            }
        }

        System.out.println(hiList.size());
    }


    static int toInt(String s) {
        return Integer.parseInt(s);
    }
}
