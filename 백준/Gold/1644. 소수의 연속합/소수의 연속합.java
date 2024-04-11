import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] prime = new boolean[4_000_001];
    static List<Integer> primeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int N = toInt(br.readLine());
        if (N == 1) {
            System.out.println(0);
            return;
        }

        primeCheck(N);

        int start = 0;
        int end = 0;
        int count = 0;

        while (start <= end && end < primeList.size()) {
            int sum = IntStream.rangeClosed(start, end).map(i -> primeList.get(i)).sum();

            if(sum < N) {
                end++;
            }

            if (sum > N) {
                start ++;
            }

            if (sum == N) {
                count++;
                start ++;
                end++;
            }

        }

        System.out.println(count);

    }

    public static void primeCheck(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (prime[i]) continue;
            for (int j = i * i; j <= num; j += i) {
                prime[j] = true;
            }
        }

        for (int i = 2; i <= num; i++) {
            if (!prime[i]) primeList.add(i);
        }
    }

    private static int toInt(String val) {
        return Integer.parseInt(val);
    }

}