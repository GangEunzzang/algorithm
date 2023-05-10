import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    private static int init;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        init = N;
        sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");

        rsc(N);


        System.out.println(sb);
    }

    public static void rsc(int N) {

        if (N == 0) {
            ____(init); 재귀함수가_뭔가요();
            ____(init); 재귀함수는();
            for (int i = init; i >= 0; i--) {
                ____(i); 라고답변하였지();
            }
            return;
        }

        ____(Math.abs(init - N)); 재귀함수가_뭔가요();
        ____(Math.abs(init - N)); 잘_들어보게();
        ____(Math.abs(init - N)); 마을사람들은();
        ____(Math.abs(init - N)); 그의_답은();

        rsc(--N);

    }

    public static void 재귀함수가_뭔가요() {
        sb.append("\"재귀함수가 뭔가요?\"").append("\n");
    }

    public static void 잘_들어보게() {
        sb.append("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.").append("\n");
    }

    public static void 마을사람들은() {
        sb.append("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.").append("\n");
    }

    public static void 그의_답은() {
        sb.append("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"").append("\n");
    }

    public static void 재귀함수는() {
        sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"").append("\n");
    }

    public static void 라고답변하였지() {
        sb.append("라고 답변하였지.").append("\n");
    }

    public static void ____(int n) {
        while (n != 0) {
            sb.append("____");
            n--;
        }
    }

}