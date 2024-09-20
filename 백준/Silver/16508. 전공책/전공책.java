import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = Integer.MAX_VALUE;
    static int N; // 책의 개수
    static int[][] books; // 책별 알파벳 개수 카운트
    static int[] prices; // 책의 가격
    static int[] targetCount; // 목표 단어의 알파벳 카운트

    public static void main(String[] args) throws IOException {
        String target = br.readLine();
        N = Integer.parseInt(br.readLine());
        books = new int[N][26];
        prices = new int[N]; 
        targetCount = new int[26];

        // 목표 단어의 알파벳 카운트 저장
        for (char c : target.toCharArray()) {
            targetCount[c - 'A']++;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            prices[i] = Integer.parseInt(st.nextToken()); // 책 가격
            char[] charArray = st.nextToken().toCharArray(); // 책 제목

            for (char c : charArray) {
                books[i][c - 'A']++;
            }
        }

        search(0, new int[26], 0);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void search(int bookIdx, int[] currentCount, int currentCost) {
        if (bookIdx == N) {
            if (canFormWord(currentCount)) {
                answer = Math.min(answer, currentCost); 
            }
            return;
        }

        search(bookIdx + 1, currentCount, currentCost);

        int[] newCount = Arrays.copyOf(currentCount, 26); 
        for (int i = 0; i < 26; i++) {
            newCount[i] += books[bookIdx][i]; 
        }
        
        search(bookIdx + 1, newCount, currentCost + prices[bookIdx]);
    }

    static boolean canFormWord(int[] currentCount) {
        for (int i = 0; i < 26; i++) {
            if (currentCount[i] < targetCount[i]) {
                return false;
            }
        }
        return true;
    }
}
