import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(st.nextToken()); // 패티 개수
        int B = Integer.parseInt(st.nextToken()); // 치즈 개수

        if (B >= A) {
            System.out.println("NO");
            return;
        }

        int count = 0;

        while (true) {
            if (A > 2 && A - B == 1) {
                while (B-- > 0) {
                    sb.append("ab");
                }

                A = 0;
                B = 0;

                sb.append("a");
                sb.append("\n");
                count++;
                break;
            }

            if (A >= 2 && B >= 1) {
                sb.append("aba");
                sb.append("\n");
                A -= 2;
                B -= 1;
                count++;
            } else {
                break;
            }
        }

        if (A != 0 || B != 0) {
            System.out.println("NO");
        } else {
            sb.insert(0, count + "\n");
            sb.insert(0, "YES" + "\n" );
            System.out.println(sb);
        }


    }
}