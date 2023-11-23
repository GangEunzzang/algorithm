import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> electronics = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> socket = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            electronics.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < M; i++) {
            if (electronics.isEmpty()) break;
            socket.add(electronics.poll());
        }

        int time = 0;
        while (!socket.isEmpty()) {
            Integer minTime = socket.poll();

            List<Integer> list = socket.stream()
                    .map(i -> i - minTime)
                    .filter(i -> i > 0)
                    .collect(Collectors.toList());

            socket = new PriorityQueue<>();
            socket.addAll(list);

            while (socket.size() < M && !electronics.isEmpty()) {
                socket.add(electronics.poll());
            }

            time += minTime;
        }

        System.out.println(time);
    }



}