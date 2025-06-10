import java.io.*;

public class Main {
    static final int MAX_N = 200;
    static int N, M, K;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr = new int[MAX_N];
    static int[] current = new int[MAX_N];
    static int[] next = new int[MAX_N];

    public static void main(String[] args) throws IOException {
        String[] tokens = br.readLine().split(" ");
        N = Integer.parseInt(tokens[0]);
        M = Integer.parseInt(tokens[1]);
        K = Integer.parseInt(tokens[2]);

        int currentSize = 0;
        for (int i = 0; i < M; i++) {
            int v = Integer.parseInt(br.readLine());
            current[currentSize++] = v;
        }

        while (K-- > 0) {
            for (int i = 0; i < currentSize; i++) {
                int idx = current[i];
                arr[(idx - 1 + N) % N]++;
                arr[(idx + 1) % N]++;
            }

            int nextSize = 0;
            for (int i = 0; i < N; i++) {
                if (arr[i] == 1) {
                    next[nextSize++] = i;
                }
                arr[i] = 0; 
            }

            int[] temp = current;
            current = next;
            next = temp;
            currentSize = nextSize;
        }

        System.out.println(currentSize);
    }
}
