import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static List<Book> bookList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 남은 기간
        M = Integer.parseInt(st.nextToken()); // 챕터의 수

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int page = Integer.parseInt(st.nextToken());
            bookList.add(new Book(day, page));
        }

        int[] dp = new int[N + 1];

        for (int i = 0; i < M; i++) {
            Book book = bookList.get(i);

            for (int j = N; j >= book.day ; j--) {
                dp[j] = Math.max(dp[j], dp[j - book.day] + book.page);
            }
        }

        System.out.println(dp[N]);
    }


    private static class Book {
        int day;
        int page;

        public Book(int day, int page) {
            this.day = day;
            this.page = page;
        }
    }

}


