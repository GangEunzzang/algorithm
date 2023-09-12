import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::valueOf)
                .toArray();

        if (arr[0] + arr[1] + arr[2] >= 100) {
            System.out.println("OK");
        } else {

            if (arr[0] < arr[1] && arr[0] < arr[2]) {
                System.out.println("Soongsil");
            }

            if (arr[1] < arr[0] && arr[1] < arr[2]) {
                System.out.println("Korea");
            }

            if (arr[2] < arr[0] && arr[2] < arr[1]) {
                System.out.println("Hanyang");
            }
        }

    }
}


