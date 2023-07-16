import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        int[] clone = arr.clone();
        Arrays.sort(arr);
        int idx = 0;

        for (int i = 0; i < N; i++) {
            int targetNum = arr[i];
            for (int j = 0; j < N; j++) {
                if(visited[j]) continue;
                if (clone[j] == targetNum) {
                    visited[j] = true;
                    clone[j] = idx++;
                    break;
                }
            }
        }

        IntStream.range(0, N).mapToObj(i -> clone[i] + " ").forEachOrdered(sb::append);
        System.out.println(sb);


    }
}

