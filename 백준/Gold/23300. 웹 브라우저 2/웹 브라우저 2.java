import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 웹페이지 종류 수
        int Q = Integer.parseInt(st.nextToken()); // 작업 개수

        /**
         * B : 뒤로가기            F : 앞으로 가기
         * A : 웹페이지 접속   C : 압축
         */

        Deque<Integer> backwards = new ArrayDeque<>();
        Deque<Integer> frontwards = new ArrayDeque<>();

        int nowPage = -1;

        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            String task = st.nextToken();

            if (task.equals("B")) {
                if(backwards.isEmpty()) continue;
                frontwards.push(nowPage);
                nowPage = backwards.pollLast();
            }

            else if (task.equals("F")) {
                if(frontwards.isEmpty()) continue;
                backwards.addLast(nowPage);
                nowPage = frontwards.pop();
            }

            else if (task.equals("A")) {
                frontwards.clear();
                if (nowPage != -1) backwards.addLast(nowPage);
                nowPage = Integer.parseInt(st.nextToken());
            }
            else if (task.equals("C")) {
                if(backwards.isEmpty()) continue;
                int size = backwards.size() -1;
                backwards.addLast(backwards.pollFirst());

                for (int i = 0; i < size; i++) {
                    int peekLastNum = backwards.peekLast();
                    int pollFirstNum = backwards.pollFirst();

                    if (peekLastNum == pollFirstNum) continue;

                    backwards.addLast(pollFirstNum);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(nowPage).append("\n");

        if (backwards.isEmpty()) {
            sb.append(-1 + "\n");
        } else {
            while (!backwards.isEmpty()) {
                sb.append(backwards.pollLast()).append(" ");
            }
            sb.append("\n");
        }

        if (frontwards.isEmpty()) {
            sb.append(-1);
        } else {
            while (!frontwards.isEmpty()) {
                sb.append(frontwards.pollFirst()).append(" ");
            }
        }

        System.out.println(sb);
    }

}


