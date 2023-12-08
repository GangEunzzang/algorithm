import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, result;
    static Map<String, Integer> cars = new HashMap<>();

    public static void main(String[] args) throws IOException {
        N = toInt(br.readLine());

        int inIdx = 0;
        for (int i = 0; i < N; i++) {
            cars.put(br.readLine(), inIdx++);
        }

        List<String> outCars = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            outCars.add(br.readLine());
        }

        int min = Integer.MAX_VALUE;
        for (int i = N - 1; i >= 0; i--) {
            int outSeq = cars.get(outCars.get(i));

            if (min > outSeq) {
                result++;
                min = outSeq;
            }
        }

        System.out.println(N - result);

    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}
