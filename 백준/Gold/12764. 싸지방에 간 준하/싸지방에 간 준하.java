import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<People> pq = new PriorityQueue<>();
        PriorityQueue<Computer> computerPq = new PriorityQueue<>();
        PriorityQueue<Integer> emptyComputer = new PriorityQueue<>();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            pq.add(new People(start, end));
        }

        int[] arr = new int[100001];

        int computerCount = 1;

        while (!pq.isEmpty()) {

            People people = pq.poll();

            while (!computerPq.isEmpty() && computerPq.peek().end < people.start) {
                emptyComputer.add(computerPq.poll().index);
            }

            if (!emptyComputer.isEmpty()) {
                Integer idx = emptyComputer.poll();
                computerPq.add(new Computer(idx, people.end));
                arr[idx]++;
                continue;
            }


            // 비어있으면
            if (computerPq.isEmpty()) {
                computerPq.add(new Computer(computerCount, people.end));
                arr[computerCount]++;
                continue;
            }

            // 차지 할 수 없을경우
            computerCount++;
            computerPq.add(new Computer(computerCount, people.end));
            arr[computerCount]++;
        }

        System.out.println(computerCount);
        for (int i = 1; i <= computerCount; i++) {
            System.out.print(arr[i] + " ");
        }
    }



    static class People implements Comparable<People> {
        int start;
        int end;

        public People(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(People o) {
            return Integer.compare(this.start, o.start);
        }
    }

    static class Computer implements Comparable<Computer> {
        int end;
        int index;

        public Computer(int index, int end) {
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Computer o) {
            return Integer.compare(this.end, o.end);
        }
    }
}

