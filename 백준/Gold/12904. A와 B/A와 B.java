import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();

        StringBuffer st = new StringBuffer(T);

        for (int i = T.length()-1; i >= S.length(); i--) {

            if (st.charAt(i) == 'A') {
                st.deleteCharAt(i);
            } else if (st.charAt(i) == 'B') {
                st.deleteCharAt(i);
                st.reverse();
            }
        }

        System.out.println(S.equals(st.toString()) ? 1 : 0);

    }

}
