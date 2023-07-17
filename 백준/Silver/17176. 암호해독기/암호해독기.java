import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean flag = true;

        int[] numbers = new int[100_001];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            numbers[num]++;
        }

        String s = br.readLine();

        for (char c : s.toCharArray()) {
            if (!flag) break;

            if (c == ' ') {
                if (numbers[0] > 0) numbers[0]--;
                else flag = false;
                continue;
            }

            int result = 0;
            if (Character.isUpperCase(c)) result = c - 'A' + 1;
            if (Character.isLowerCase(c)) result = c - 'a' + 27;
            
            if (numbers[result] > 0) numbers[result]--;
            else flag = false;
        }

        System.out.println(flag ? "y" : "n");


    }
}

