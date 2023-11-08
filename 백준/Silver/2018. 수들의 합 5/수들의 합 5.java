import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        int left = 0;
        int right = 0;
        int result = 0;

        while (right <= N) {
            if (answer == N) result++;

            if (answer < N) {
                answer += ++right;
            }

            if (answer >= N) {
                answer -= left++;
            }
        }

        System.out.println(result);

    }

}