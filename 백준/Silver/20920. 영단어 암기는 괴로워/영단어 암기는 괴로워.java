import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> wordCountMap = new HashMap<>();


        while (N-- > 0) {
            String word = br.readLine();
            if (word.length() >= M) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }

        PriorityQueue<Word> pq = new PriorityQueue<>((o1, o2) -> {
            if (o2.count != o1.count) {
                return o2.count - o1.count;
            }

            if (o2.value.length() != o1.value.length()) {
                return o2.value.length() - o1.value.length();
            }

            return o1.value.compareTo(o2.value);
        });

        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            pq.add(new Word(entry.getValue(), entry.getKey()));
        }

        while (!pq.isEmpty()) {
            sb.append(pq.poll().value).append("\n");
        }

        System.out.println(sb);

    }

    static class Word {
        int count;
        String value;

        public Word(int count, String value) {
            this.count = count;
            this.value = value;
        }
    }
    
}
