import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = toInt(st.nextToken());
        M = toInt(st.nextToken());
        K = toInt(st.nextToken());

        Queue<Student> pq = new PriorityQueue<>((o1,o2) -> {
            if (o2.score > o1.score) return 1;
            if (o2.score < o1.score) return -1;
            return 0;
        });

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int idx = toInt(st.nextToken());
                double score = Double.parseDouble(st.nextToken());
                pq.add(new Student(idx ,score));
            }
        }

        boolean[] visited = new boolean[N + 1];
        double answer = 0;

        while (K > 0) {
            Student student = pq.poll();
            if (visited[student.idx]) continue;

            visited[student.idx] = true;
            answer += student.score;
            K--;
        }

        System.out.printf("%.1f", answer);
    }

    static class Student {
        int idx;
        double score;

        @Override
        public String toString() {
            return "Student{" +
                    "idx=" + idx +
                    ", score=" + score +
                    '}';
        }

        public Student(int idx, double score) {
            this.idx = idx;
            this.score = score;
        }
    }


    static int toInt(String val) {
        return Integer.parseInt(val);
    }


}
